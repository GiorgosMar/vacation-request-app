package com.vacationRequest.controller;

import com.vacationRequest.dto.AuthenticationResponse;
import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/login/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody UsersDTO usersDTO){
        return ResponseEntity.ok(usersService.authenticate(usersDTO));
    }

}
