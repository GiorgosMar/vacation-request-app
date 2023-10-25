package com.vacationRequest.dto;

import com.vacationRequest.domain.Company;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
public class EmployeeDTO {
    private Long id;
    private String name;
    private String surname;
    private LocalDate startDate;
    private Integer vacationDays;
    private Double salary;
    private String employmentType;
    private Boolean isAdmin;
    private Company company;
}
