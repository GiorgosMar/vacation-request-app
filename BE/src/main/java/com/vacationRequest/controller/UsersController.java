package com.vacationRequest.controller;

import com.vacationRequest.dto.AuthUserDTO;
import com.vacationRequest.dto.AuthenticationUserDTO;
import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
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
    @PostMapping(path = "/login/authenticate")
    public ResponseEntity<Set<String>> authentication(@RequestBody UsersDTO usersDTO){
         AuthUserDTO authUserDTO = usersService.authenticate(usersDTO);

        return ResponseEntity.ok().header("Authorization", authUserDTO.getToken()).body(authUserDTO.getUserRoleSet());
    }
    @GetMapping(path = "/verify")
    public ResponseEntity<AuthenticationUserDTO> verify(HttpServletRequest request){
        boolean authFlag = (boolean) request.getAttribute("auth");
        String userEmail = (String) request.getAttribute("email");

        AuthenticationUserDTO authenticationUserDTO = new AuthenticationUserDTO();

        if (!authFlag){
            authenticationUserDTO.setIsAuth(false);
            return ResponseEntity.ok(authenticationUserDTO);
        }

        return ResponseEntity.ok(usersService.getRoles(userEmail));
    }

}
