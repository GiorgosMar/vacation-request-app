package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.enums.VacationRequestStatus;
import com.example.demo.domain.VacationRequest;
import com.example.demo.exception.StatusException;
import com.example.demo.exception.VacationDaysException;
import com.example.demo.repository.VacationRequestRepository;
import com.example.demo.service.mapper.VacationRequestMapper;
import com.example.demo.utils.Const;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class VacationRequestService {
    private final VacationRequestRepository vacationRequestRepository;
    private final VacationRequestMapper vacationRequestMapper;
    private final EmployeeService employeeService;

    public VacationRequestService(VacationRequestRepository vacationRequestRepository, VacationRequestMapper vacationRequestMapper, EmployeeService employeeService) {
        this.vacationRequestRepository = vacationRequestRepository;
        this.vacationRequestMapper = vacationRequestMapper;
        this.employeeService = employeeService;
    }
    public List<VacationRequestDTO> getAllVacationRequests(){
        List<VacationRequest> vacationRequestList = vacationRequestRepository.findAll();
        List<VacationRequestDTO> vacationRequestDTOList = vacationRequestMapper.toDTO(vacationRequestList);
        return ResponseEntity.ok().body(vacationRequestDTOList).getBody();
    }
    public VacationRequestDTO getVacationRequestById(Long vacationRequestId){
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(vacationRequestId);
        if(vacationRequestOptional.isEmpty()){
            throw new EntityNotFoundException("Vacation request not found for id : " + vacationRequestId);
        }
        VacationRequestDTO vacationRequestDTO = vacationRequestMapper.toDTO(vacationRequestOptional.get());
        return ResponseEntity.ok().body(vacationRequestDTO).getBody();
    }
    public List<VacationRequestDTO> getVacationRequestsTimeline(VacationRequestTimelineDTO vacationRequestTimelineDTO){
        List<VacationRequest> vacationRequestList = vacationRequestRepository.findByTimelineAndStatus(vacationRequestTimelineDTO.getStartDate(),
                vacationRequestTimelineDTO.getEndDate(),
                vacationRequestTimelineDTO.getStatus()
        );
        List<VacationRequestDTO> vacationRequestDTOList = vacationRequestMapper.toDTO(vacationRequestList);
        return ResponseEntity.ok().body(vacationRequestDTOList).getBody();
    }
    public VacationRequestDTO addNewVacationRequest(VacationRequestInfoDTO vacationRequestInfoDTO) {
        VacationRequestDTO vacationRequestDTO;
        EmployeeDTO employee = employeeService.getEmployeeById(vacationRequestInfoDTO.getEmployee().getId());
        long difference = ChronoUnit.DAYS.between(vacationRequestInfoDTO.getStartDate(), vacationRequestInfoDTO.getEndDate());
        vacationRequestInfoDTO.setHoliday(Math.toIntExact(difference));
        if(employee.getVacationDays() < vacationRequestInfoDTO.getHoliday()){
            throw new VacationDaysException(Const.EMPLOYEE_DOESNT_HAVE_SO_MANY_VACATION_DAYS);
        }
        VacationRequest vacationRequest = vacationRequestMapper.toEntity(vacationRequestInfoDTO);
        vacationRequest.setStatus(VacationRequestStatus.PENDING.getValue());
        vacationRequestRepository.save(vacationRequest);
        vacationRequestDTO = vacationRequestMapper.toDTO(vacationRequest);
        return ResponseEntity.ok().body(vacationRequestDTO).getBody();
    }
    public void deleteVacationRequest(Long vacationRequestId) {
        boolean exists = vacationRequestRepository.existsById(vacationRequestId);
        if(!exists){
            throw new EntityNotFoundException("Vacation request with id " + vacationRequestId + " does not exist");
        }
        vacationRequestRepository.deleteById(vacationRequestId);
    }
    @Transactional
    public VacationRequestDTO updateVacationRequest(Long vacationRequestId, VacationRequest vacationRequest) {
        boolean exists = vacationRequestRepository.existsById(vacationRequestId);
        VacationRequestDTO vacationRequestDTO;
        if(!exists){
            throw new EntityNotFoundException("Vacation request with id " + vacationRequestId + " does not exist");
        }else{
            vacationRequestDTO = vacationRequestMapper.toDTO(vacationRequestRepository.save(vacationRequest));
        }
        return ResponseEntity.ok().body(vacationRequestDTO).getBody();
    }
    @Transactional
    public VacationRequestDTO updateVacationRequestStatus(VacationRequestStatusDTO vacationRequestStatusDTO) {
        VacationRequestDTO vacationRequestDTO;
        Optional<VacationRequest> vacationRequestOptional = vacationRequestRepository.findById(vacationRequestStatusDTO.getVacationId());
        if(vacationRequestOptional.isEmpty()){
            throw new EntityNotFoundException("Vacation request not found for id : " + vacationRequestStatusDTO.getVacationId());
        }
        VacationRequest vacationRequest = vacationRequestOptional.get();
        if(VacationRequestStatus.resolve(vacationRequestStatusDTO.getStatus()) == null ){
            throw new StatusException(Const.NOT_VALID_STATUS);
        }
        if(VacationRequestStatus.resolve(vacationRequestStatusDTO.getStatus()).equals(VacationRequestStatus.ACCEPTED)) {
            int remainingVacationDays = vacationRequest.getEmployee().getVacationDays() - vacationRequest.getDays();
            vacationRequest.getEmployee().setVacationDays(remainingVacationDays);
            vacationRequest.setStatus(VacationRequestStatus.APPROVED.getValue());
        }else if(VacationRequestStatus.resolve(vacationRequestStatusDTO.getStatus()).equals(VacationRequestStatus.REJECTED)){
            vacationRequest.setStatus(VacationRequestStatus.REJECTED.getValue());
        }
        vacationRequestRepository.save(vacationRequest);
        vacationRequestDTO = vacationRequestMapper.toDTO(vacationRequest);
        return ResponseEntity.ok().body(vacationRequestDTO).getBody();
    }
}