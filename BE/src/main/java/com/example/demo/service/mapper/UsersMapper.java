package com.example.demo.service.mapper;

import com.example.demo.domain.Users;
import com.example.demo.dto.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {
    public UsersDTO toDTO(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setConfirmPassword(users.getConfirmPassword());
        usersDTO.setEmployee(users.getEmployee());
        return usersDTO;
    }
}
