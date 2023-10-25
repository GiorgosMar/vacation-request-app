package com.vacationRequest.controller;

import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.service.UsersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(path = "/users/login/email")
    public UsersDTO checkIfEmailExists(@RequestBody UsersDTO usersDTO){
        String email = usersDTO.getEmail();
        return usersService.checkIfEmailExists(email);
    }
    @PostMapping(path = "/users/login/password")
    public UsersDTO checkIfPasswordIsCorrect(@RequestBody UsersDTO usersDTO){
        String email = usersDTO.getEmail();
        String password = usersDTO.getPassword();

        UsersDTO userDTO = usersService.checkIfEmailExists(email);
        return usersService.checkIfPasswordIsCorrect(password, userDTO);
    }

}
