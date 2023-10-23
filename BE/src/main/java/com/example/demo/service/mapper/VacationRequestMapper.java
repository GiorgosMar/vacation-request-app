package com.example.demo.service.mapper;

import com.example.demo.domain.VacationRequest;
import com.example.demo.dto.VacationRequestDTO;
import com.example.demo.dto.VacationRequestInfoDTO;
import com.example.demo.dto.VacationRequestStatusDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VacationRequestMapper {
    public VacationRequestDTO toDTO(VacationRequest vacationRequest) {
        VacationRequestDTO vacationRequestDTO = new VacationRequestDTO();
        vacationRequestDTO.setId(vacationRequest.getId());
        vacationRequestDTO.setDays(vacationRequest.getDays());
        vacationRequestDTO.setStartDate(vacationRequest.getStartDate());
        vacationRequestDTO.setEndDate(vacationRequest.getEndDate());
        vacationRequestDTO.setStatus(vacationRequest.getStatus());
        vacationRequestDTO.setEmployee(vacationRequest.getEmployee());
        return vacationRequestDTO;
    }
    public List<VacationRequestDTO> toDTO(List<VacationRequest> vacationRequestList) {
        List<VacationRequestDTO> vacationRequestproductDTOList = new ArrayList<>();
        for (VacationRequest vacationRequest : vacationRequestList) {
            VacationRequestDTO vacationRequestDTO = toDTO(vacationRequest);
            vacationRequestproductDTOList.add(vacationRequestDTO);
        }
        return vacationRequestproductDTOList;
    }
    public VacationRequest toEntity(VacationRequestDTO vacationRequestDTO) {
        VacationRequest vacationRequest = new VacationRequest();
        vacationRequest.setId(vacationRequestDTO.getId());
        vacationRequest.setDays(vacationRequestDTO.getDays());
        vacationRequest.setStartDate(vacationRequestDTO.getStartDate());
        vacationRequest.setEndDate(vacationRequestDTO.getEndDate());
        vacationRequest.setStatus(vacationRequestDTO.getStatus());
        vacationRequest.setEmployee(vacationRequestDTO.getEmployee());
        return vacationRequest;
    }
    public VacationRequest toEntity(VacationRequestInfoDTO vacationRequestInfoDTO) {
        VacationRequest vacationRequest = new VacationRequest();
        vacationRequest.setStartDate(vacationRequestInfoDTO.getStartDate());
        vacationRequest.setEndDate(vacationRequestInfoDTO.getEndDate());
        vacationRequest.setEmployee(vacationRequestInfoDTO.getEmployee());
        vacationRequest.setDays(vacationRequestInfoDTO.getHoliday());
        return vacationRequest;
    }
    public VacationRequest toEntity(VacationRequestStatusDTO vacationRequestStatusDTO) {
        VacationRequest vacationRequest = new VacationRequest();
        vacationRequest.setId(vacationRequestStatusDTO.getVacationId());
        vacationRequest.setStatus(vacationRequestStatusDTO.getStatus());
        return vacationRequest;
    }
    public List<VacationRequest> toEntity(List<VacationRequestDTO> vacationRequestDTOList) {
        List<VacationRequest> vacationRequestList = new ArrayList<>();
        for (VacationRequestDTO vacationRequestDTO : vacationRequestDTOList) {
            VacationRequest vacationRequest = toEntity(vacationRequestDTO);
            vacationRequestList.add(vacationRequest);
        }
        return vacationRequestList;
    }
}