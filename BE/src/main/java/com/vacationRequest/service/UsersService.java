package com.vacationRequest.service;

import com.vacationRequest.domain.Users;
import com.vacationRequest.dto.AuthenticationResponse;
import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.repository.UsersRepository;

import com.vacationRequest.service.mapper.UsersMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UsersService(UsersRepository usersRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.usersRepository = usersRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse authenticate(UsersDTO usersDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                      usersDTO.getEmail(),
                      usersDTO.getPassword()
                )
        );
        Optional<Users> usersOptional = usersRepository.findByEmail(usersDTO.getEmail());
        if(usersOptional.isEmpty()){
            throw new EntityNotFoundException("User with email: " + usersDTO.getEmail() + " doesn't exist");
        }
        Users user = usersOptional.get();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
