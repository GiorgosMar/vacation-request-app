package com.vacationRequest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VacationRequestTimelineDTO {
    private Long companyId;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
}
