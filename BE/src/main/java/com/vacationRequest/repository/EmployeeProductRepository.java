package com.vacationRequest.repository;

import com.vacationRequest.domain.EmployeeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeProductRepository extends JpaRepository<EmployeeProduct, Long> {
    List<EmployeeProduct> findAllByEmployeeCompanyId(@Param("companyId") Long companyId);
}
