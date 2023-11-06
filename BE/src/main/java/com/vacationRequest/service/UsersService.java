package com.vacationRequest.service;

import com.vacationRequest.domain.Users;
import com.vacationRequest.dto.UsersDTO;
import com.vacationRequest.repository.UsersRepository;

import com.vacationRequest.service.mapper.UsersMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
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

    public UsersDTO checkIfEmailExists(String email){
        Optional<Users> usersOptional = usersRepository.findByEmail(email);
        if(usersOptional.isEmpty()){
            throw new EntityNotFoundException("User with email: " + email + " doesn't exist");
        }
        Users user = usersOptional.get();
        return usersMapper.toDTO(user);
    }

//    public UserDetails checkIfEmailExists(String email){
//        Optional<Users> usersOptional = usersRepository.findByEmail(email);
//        if(usersOptional.isEmpty()){
//            throw new EntityNotFoundException("User with email: " + email + " doesn't exist");
//        }
//        return usersOptional.get();
//    }

    public UsersDTO checkIfPasswordIsCorrect(String enteredPassword, UsersDTO usersDTO){
        if(enteredPassword.isEmpty()){
            throw new EntityNotFoundException("Password field is empty!");
        }
        if (!enteredPassword.equals(usersDTO.getPassword())){
            throw new EntityNotFoundException("Password is wrong!");
        }
        return usersDTO;
    }
}
