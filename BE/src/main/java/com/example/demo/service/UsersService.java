package com.example.demo.service;

import com.example.demo.domain.Users;
import com.example.demo.dto.UsersDTO;
import com.example.demo.repository.UsersRepository;

import com.example.demo.service.mapper.UsersMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersService(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    public UsersDTO emailExists(String email){
        Optional<Users> usersOptional = usersRepository.findUserIfexists(email);
        if(usersOptional.isEmpty()){
            throw new EntityNotFoundException("User with email: " + email + " doesn't exist");
        }
        Users user = usersOptional.get();
        UsersDTO usersDTO = usersMapper.toDTO(user);
        return ResponseEntity.ok().body(usersDTO).getBody();
    }
}
