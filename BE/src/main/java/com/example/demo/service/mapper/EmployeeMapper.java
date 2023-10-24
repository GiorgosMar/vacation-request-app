package com.example.demo.service.mapper;

import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EmployeeMapper {
    public EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setStartDate(employee.getStartDate());
        employeeDTO.setVacationDays(employee.getVacationDays());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setEmploymentType(employee.getEmploymentType());
        employeeDTO.setIsAdmin(employee.getIsAdmin());
        employeeDTO.setCompany(employee.getCompany());
        return employeeDTO;
    }
    public Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setVacationDays(employeeDTO.getVacationDays());
        employee.setSalary(employeeDTO.getSalary());
        employee.setEmploymentType(employeeDTO.getEmploymentType());
        employee.setIsAdmin(employeeDTO.getIsAdmin());
        employee.setCompany(employeeDTO.getCompany());
        return employee;
    }

    public List<EmployeeDTO> toDTO(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee employee : employeeList) {
            EmployeeDTO employeeDTO = toDTO(employee);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }
    public List<Employee> toEntity(List<EmployeeDTO> employeeDTOList) {
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeDTOList) {
            Employee employee = toEntity(employeeDTO);
            employeeList.add(employee);
        }
        return employeeList;
    }
}