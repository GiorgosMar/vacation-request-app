package com.vacationRequest.repository;

import com.vacationRequest.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT SUM(employee.salary) FROM Employee employee INNER JOIN Company company ON employee.company.id = company.id WHERE employee.company.id = :companyId")
    double findAllEmployeesSalary(@Param("companyId") Long companyId);

    @Query("SELECT employee FROM Employee employee INNER JOIN Company company ON employee.company.id = company.id WHERE employee.company.id = :companyId")
    List<Employee> findAllEmployeesByCompanyId(@Param("companyId") Long companyId);
}
