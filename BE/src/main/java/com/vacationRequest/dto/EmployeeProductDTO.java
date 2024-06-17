package com.vacationRequest.dto;

import com.vacationRequest.domain.Employee;
import com.vacationRequest.domain.Product;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmployeeProductDTO {
    private Long id;
    private Employee employee;
    private Product product;
}
