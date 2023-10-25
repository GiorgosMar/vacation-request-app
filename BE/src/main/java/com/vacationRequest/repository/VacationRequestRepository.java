package com.vacationRequest.repository;

import com.vacationRequest.domain.VacationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VacationRequestRepository extends JpaRepository<VacationRequest, Long> {
    @Query("SELECT vacationRequest FROM VacationRequest vacationRequest WHERE vacationRequest.startDate <= :startDate AND vacationRequest.endDate >= :endDate AND vacationRequest.status = :status")

    List<VacationRequest> findByTimelineAndStatus(@Param("startDate")LocalDate startDate, @Param("endDate")LocalDate endDate, @Param("status") String status);
}