package com.example.demo.controller;

import com.example.demo.domain.VacationRequest;
import com.example.demo.dto.VacationRequestDTO;
import com.example.demo.dto.VacationRequestInfoDTO;
import com.example.demo.dto.VacationRequestStatusDTO;
import com.example.demo.dto.VacationRequestTimelineDTO;
import com.example.demo.service.VacationRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class VacationRequestController {
    private final VacationRequestService vacationRequestService;

    public VacationRequestController(VacationRequestService vacationRequestService) {
        this.vacationRequestService = vacationRequestService;
    }

    @GetMapping(path = "/vacationReq")
    public List<VacationRequestDTO> getAllVacationRequests(){
        return vacationRequestService.getAllVacationRequests();
    }

    @GetMapping(path = "/vacationReq/{vacationRequestId}")
    public VacationRequestDTO getVacationRequestById(@PathVariable("vacationRequestId") Long vacationRequestId){
        return vacationRequestService.getVacationRequestById(vacationRequestId);
    }

    @GetMapping(path = "/vacationReq/timeline")
    public List<VacationRequestDTO> getVacationRequestsTimeline(@RequestBody VacationRequestTimelineDTO vacationRequestTimelineDTO){
        return vacationRequestService.getVacationRequestsTimeline(vacationRequestTimelineDTO);
    }

    @PostMapping(path = "/vacationReq")
    public VacationRequestDTO newVacationRequest(@RequestBody VacationRequestInfoDTO vacationRequestInfoDTO){
        return vacationRequestService.addNewVacationRequest(vacationRequestInfoDTO);
    }

    @DeleteMapping(path = "/vacationReq/{vacationRequestId}")
    public void deleteVacationRequest(@PathVariable("vacationRequestId") Long vacationRequestId){
        vacationRequestService.deleteVacationRequest(vacationRequestId);
    }

    @PutMapping(path = "/vacationReq/{vacationRequestId}")
    public VacationRequestDTO updateVacationRequest(
            @PathVariable("vacationRequestId") Long vacationRequestId,
            @RequestBody VacationRequest vacationRequest){
        return vacationRequestService.updateVacationRequest(vacationRequestId, vacationRequest);
    }

    @PutMapping(path = "/vacationReq/status/{vacationId}")
    public VacationRequestDTO updateVacationRequestStatus(
            @RequestBody VacationRequestStatusDTO vacationRequestStatusDTO){
        return vacationRequestService.updateVacationRequestStatus(vacationRequestStatusDTO);
    }
}
