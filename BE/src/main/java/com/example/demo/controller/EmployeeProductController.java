package com.example.demo.controller;

import com.example.demo.domain.EmployeeProduct;
import com.example.demo.domain.Product;
import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.service.EmployeeProductService;
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
