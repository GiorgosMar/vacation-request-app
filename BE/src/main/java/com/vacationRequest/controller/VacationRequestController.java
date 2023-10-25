package com.vacationRequest.controller;

import com.vacationRequest.domain.VacationRequest;
import com.vacationRequest.dto.VacationRequestDTO;
import com.vacationRequest.dto.VacationRequestInfoDTO;
import com.vacationRequest.dto.VacationRequestStatusDTO;
import com.vacationRequest.dto.VacationRequestTimelineDTO;
import com.vacationRequest.service.VacationRequestService;
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
