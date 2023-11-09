package com.vacationRequest.controller;

import com.vacationRequest.dto.AuthenticationResponse;
import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(path = "/login/email")
    public UsersDTO checkIfEmailExists(@RequestBody UsersDTO usersDTO){
        String email = usersDTO.getEmail();
        return usersService.checkIfEmailExists(email);
    }
    @PostMapping(path = "/login/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody UsersDTO usersDTO){
        return ResponseEntity.ok(usersService.authenticate(usersDTO));
    }

}
