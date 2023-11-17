package com.vacationRequest.service;

import com.vacationRequest.domain.UserRole;
import com.vacationRequest.domain.Users;
import com.vacationRequest.dto.AuthUserDTO;
import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.repository.UsersRepository;
import com.vacationRequest.service.mapper.UsersMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final AuthenticationManager authenticationManager;
    private final UsersMapper usersMapper;
    private final JwtService jwtService;

    public UsersService(UsersRepository usersRepository, AuthenticationManager authenticationManager, UsersMapper usersMapper, JwtService jwtService) {
        this.usersRepository = usersRepository;
        this.authenticationManager = authenticationManager;
        this.usersMapper = usersMapper;
        this.jwtService = jwtService;
    }

    public AuthUserDTO authenticate(UsersDTO usersDTO) {
        AuthUserDTO authUserDTO = new AuthUserDTO();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usersDTO.getEmail(), usersDTO.getPassword()));
        Optional<Users> usersOptional = usersRepository.findByEmail(usersDTO.getEmail());
        if (usersOptional.isEmpty()) {
            throw new EntityNotFoundException("User with email: " + usersDTO.getEmail() + " doesn't exist");
        }
        Users user = usersOptional.get();
        String jwtToken = jwtService.generateToken(user);

        Set<String> userRoleSet = new HashSet<>();
        Set<UserRole> userRole = user.getUserRole();

        for (UserRole role : userRole) {
            String usRole = role.getRole().getDescription();
            userRoleSet.add(usRole);
        }

        authUserDTO.setToken("Bearer " + jwtToken);
        authUserDTO.setUserRoleSet(userRoleSet);

        return ResponseEntity.ok().body(authUserDTO).getBody();

    }
}
