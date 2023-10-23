package com.example.demo.dto;

import com.example.demo.domain.Company;
import com.example.demo.domain.Employee;
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
