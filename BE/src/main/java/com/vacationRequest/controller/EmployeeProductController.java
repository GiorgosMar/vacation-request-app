package com.vacationRequest.controller;

import com.vacationRequest.domain.EmployeeProduct;
import com.vacationRequest.domain.Product;
import com.vacationRequest.dto.EmployeeProductDTO;
import com.vacationRequest.service.EmployeeProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1")
public class EmployeeProductController {
    private final EmployeeProductService employeeProductService;

    public EmployeeProductController(EmployeeProductService employeeProductService) {
        this.employeeProductService = employeeProductService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/employeeProduct/company/{companyId}")
    public Map<String, List<Product>> getEmployeeProductsByCompany(@PathVariable("companyId") Long companyId){
        return employeeProductService.getEmployeeProductsByCompany(companyId);
    }

    @GetMapping(path = "/employeeProduct")
    public List<EmployeeProductDTO> getAllEmployeeProducts(){
        return employeeProductService.getAllEmployeeProducts();
    }

    @GetMapping(path = "/employeeProduct/{employeeProductId}")
    public EmployeeProductDTO getEmployeeProductById(@PathVariable("employeeProductId") Long employeeProductId){
        return employeeProductService.getEmployeeProductById(employeeProductId);
    }

    @PostMapping(path = "/employeeProduct")
    public EmployeeProductDTO addNewEmployeeProduct(@RequestBody EmployeeProduct employeeProduct){
        return employeeProductService.addNewEmployeeProduct(employeeProduct);
    }

    @DeleteMapping(path = "/employeeProduct/{employeeProductId}")
    public void deleteEmployeeProduct(@PathVariable("employeeProductId") Long employeeProductId){
        employeeProductService.deleteEmployeeProduct(employeeProductId);
    }

    @PutMapping(path = "/employeeProduct/{employeeProductId}")
    public EmployeeProductDTO updateEmployeeProduct(
            @PathVariable("employeeProductId") Long employeeProductId,
            @RequestBody EmployeeProduct employeeProduct
    ){
        return employeeProductService.updateEmployeeProduct(employeeProductId, employeeProduct);
    }
}
