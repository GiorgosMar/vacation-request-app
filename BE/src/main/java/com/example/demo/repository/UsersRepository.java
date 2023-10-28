package com.example.demo.repository;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT user FROM Users user WHERE user.email = :email")
    Optional<Users> findUserIfexists(@Param("email") String email);
}