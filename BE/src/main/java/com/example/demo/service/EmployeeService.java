package com.example.demo.service;
import com.example.demo.domain.Employee;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.mapper.EmployeeMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }
    public double getMonthlyExpenses(Long companyId){
        return employeeRepository.findAllEmployeesSalary(companyId);
    }
    public List<EmployeeDTO> getEmployeesByCompanyId(Long companyId){
        List<Employee> employeeList = employeeRepository.findAllEmployeesByCompanyId(companyId);
        List<EmployeeDTO> employeeDTOList = employeeMapper.toDTO(employeeList);
        return ResponseEntity.ok().body(employeeDTOList).getBody();
    }
    public List<EmployeeDTO> getAllEmployees(){
       List<Employee> employeeList = employeeRepository.findAll();
       List<EmployeeDTO> employeeDTOList = employeeMapper.toDTO(employeeList);
       return ResponseEntity.ok().body(employeeDTOList).getBody();
    }
    public EmployeeDTO getEmployeeById(Long employeeId){
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if(employeeOptional.isEmpty()){
            throw new EntityNotFoundException("Employee not found for id : " + employeeId);
        }
        EmployeeDTO employeeDTO = employeeMapper.toDTO(employeeOptional.get());
        return ResponseEntity.ok().body(employeeDTO).getBody();
    }
    public EmployeeDTO addNewEmployee(Employee employee) {
        EmployeeDTO employeeDTO;
        employeeDTO = employeeMapper.toDTO(employeeRepository.save(employee));
        return ResponseEntity.ok().body(employeeDTO).getBody();
    }
    public void deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists){
            throw new EntityNotFoundException("Employee with id " + employeeId + " does not exist");
        }
        employeeRepository.deleteById(employeeId);
    }
    @Transactional
    public EmployeeDTO updateEmployee(Long employeeId, Employee employee) {
        boolean exists = employeeRepository.existsById(employeeId);
        EmployeeDTO employeeDTO;
        if (!exists) {
            throw new EntityNotFoundException("Employee with id " + employeeId + " does not exist");
        } else {
            employeeDTO = employeeMapper.toDTO(employeeRepository.save(employee));
        }
        return ResponseEntity.ok().body(employeeDTO).getBody();
    }
}