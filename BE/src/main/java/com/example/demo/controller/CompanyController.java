package com.example.demo.controller;

import com.example.demo.domain.Company;
import com.example.demo.dto.CompanyDTO;
import com.example.demo.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")

public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path ="/company")
    public List<CompanyDTO> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping(path = "/company/{companyId}")
    public CompanyDTO getCompanyById(@PathVariable("companyId") Long companyId){
        return companyService.getCompanyById(companyId);
    }

    @GetMapping(path = "/company/monthlyExpenses/{companyId}")
    public double getMonthlyExpenses(@PathVariable("companyId") Long companyId){
        return companyService.getMonthlyExpenses(companyId);
    }

    @PostMapping(path = "/company")
    public CompanyDTO registerNewCompany(@RequestBody Company company){

        return companyService.addNewCompany(company);
    }

    @DeleteMapping(path = "/company/{companyId}")
    public void deleteCompany(@PathVariable("companyId") Long companyId){
        companyService.deleteCompany(companyId);
    }

    @PutMapping(path = "/company/{companyId}")
    public CompanyDTO updateCompany(
            @PathVariable("companyId") Long companyId,
            @RequestBody Company company){
        return companyService.updateCompany(companyId, company);
    }
}
