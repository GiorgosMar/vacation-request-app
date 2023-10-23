package com.example.demo.dto;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Product;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmployeeProductDTO {
    private Long id;
    private Employee employee;
    private Product product;
}
