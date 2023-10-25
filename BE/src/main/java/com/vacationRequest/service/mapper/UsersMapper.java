package com.vacationRequest.service.mapper;

import com.vacationRequest.domain.Users;
import com.vacationRequest.dto.UsersDTO;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {
    public UsersDTO toDTO(Users users) {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setEmployee(users.getEmployee());
        return usersDTO;
    }
}
