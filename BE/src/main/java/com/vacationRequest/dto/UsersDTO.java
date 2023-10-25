package com.vacationRequest.dto;

import com.vacationRequest.domain.Employee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {
    private Long id;
    private String email;
    private String password;
    private Employee employee;
}
