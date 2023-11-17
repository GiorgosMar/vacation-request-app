package com.vacationRequest.controller;

import com.vacationRequest.domain.UserRole;
import com.vacationRequest.dto.AuthUserDTO;
import com.vacationRequest.dto.AuthenticationResponse;
import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/login/authenticate")
    public ResponseEntity<Set<String>> authentication(@RequestBody UsersDTO usersDTO){
         AuthUserDTO authUserDTO = usersService.authenticate(usersDTO);

        return ResponseEntity.ok().header("Authorization", authUserDTO.getToken()).body(authUserDTO.getUserRoleSet());
    }

}
