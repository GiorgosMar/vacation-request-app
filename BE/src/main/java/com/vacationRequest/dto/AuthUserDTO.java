package com.vacationRequest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class AuthUserDTO {
    private Set<String> userRoleSet;
    private String token;
}
