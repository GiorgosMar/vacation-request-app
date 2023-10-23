package com.example.demo.dto;

import com.example.demo.domain.Employee;
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
