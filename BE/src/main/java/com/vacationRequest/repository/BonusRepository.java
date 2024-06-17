package com.vacationRequest.repository;

import com.vacationRequest.domain.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<Bonus, Long> {
}
