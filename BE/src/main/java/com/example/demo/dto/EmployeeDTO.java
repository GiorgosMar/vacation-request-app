package com.example.demo.dto;

import com.example.demo.domain.Company;
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
    private Company company;
}
