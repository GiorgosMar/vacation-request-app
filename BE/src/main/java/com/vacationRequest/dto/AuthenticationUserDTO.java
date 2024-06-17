package com.vacationRequest.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationUserDTO {
    private Set<String> userRoleSet;
    private Boolean isAuth;
}
