package com.example.demo.dto;

import com.example.demo.domain.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {
    private Long id;
    private String email;
    private String password;
    private String confirmPassword;
    private Employee employee;
}
