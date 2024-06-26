package com.vacationRequest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vacationRequest.domain.Employee;
import com.vacationRequest.domain.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class UsersDTO {
    private Long id;
    private String email;
    private String password;
    private Employee employee;
    private Set<UserRole> roles;
}
