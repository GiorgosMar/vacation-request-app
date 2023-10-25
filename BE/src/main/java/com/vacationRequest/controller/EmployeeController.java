package com.vacationRequest.controller;

import com.vacationRequest.domain.Employee;
import com.vacationRequest.dto.EmployeeDTO;
import com.vacationRequest.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/employee/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping(path = "/employee")
    public EmployeeDTO registerNewEmployee(@RequestBody Employee employee){
        return employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path = "/employee/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "/employee/{employeeId}")
    public EmployeeDTO updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestBody Employee employee
    ){
        return employeeService.updateEmployee(employeeId, employee);
    }
}
