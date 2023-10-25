package com.vacationRequest.dto;

import com.vacationRequest.domain.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VacationRequestInfoDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee employee;
    private Integer holiday;
}
