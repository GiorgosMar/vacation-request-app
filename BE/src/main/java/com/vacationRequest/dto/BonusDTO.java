package com.vacationRequest.dto;

import com.vacationRequest.domain.Company;
import com.vacationRequest.domain.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BonusDTO {
    private Long id;
    private Employee employee;
    private Company company;
    private Double amount;
}
