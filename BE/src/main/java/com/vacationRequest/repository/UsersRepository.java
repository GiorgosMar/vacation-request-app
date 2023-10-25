package com.vacationRequest.repository;

import com.vacationRequest.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {


   @Query("SELECT users FROM Users users WHERE users.email = :email")
   Optional<Users> findUsersByEmail(@Param("email") String email);
}
