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
    private final UsersMapper usersMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public UsersService(UsersRepository usersRepository, UsersMapper usersMapper, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public Boolean checkIfEmailExists(String email){
        Optional<Users> usersOptional = usersRepository.findByEmail(email);
        if(usersOptional.isEmpty()){
            throw new EntityNotFoundException("User with email: " + email + " doesn't exist");
        }
        return true;
    }

    public AuthenticationResponse authenticate(UsersDTO usersDTO){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                      usersDTO.getEmail(),
                      usersDTO.getPassword()
                )
        );
        checkIfEmailExists(usersDTO.getEmail());
        Optional<Users> usersOptional = usersRepository.findByEmail(usersDTO.getEmail());
        Users user = usersOptional.get();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
