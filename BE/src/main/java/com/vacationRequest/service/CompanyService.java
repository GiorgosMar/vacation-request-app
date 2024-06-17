package com.vacationRequest.service;

import com.vacationRequest.domain.Company;
import com.vacationRequest.dto.CompanyDTO;
import com.vacationRequest.exception.NameAlreadyExistsException;
import com.vacationRequest.repository.CompanyRepository;
import com.vacationRequest.service.mapper.CompanyMapper;
import com.vacationRequest.utils.Const;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeService employeeService;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, EmployeeService employeeService, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.employeeService = employeeService;
        this.companyMapper = companyMapper;
    }

    public List<CompanyDTO> getAllCompanies() {
        List<Company> companyList = companyRepository.findAll();
        List<CompanyDTO> companyDTOList = companyMapper.toDTO(companyList);
        return ResponseEntity.ok().body(companyDTOList).getBody();
    }

    public double getMonthlyExpenses(Long companyId) {
        double amount = employeeService.getMonthlyExpenses(companyId);
        return ResponseEntity.ok().body(amount).getBody();
    }

    public CompanyDTO getCompanyById(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isEmpty()) {
            throw new EntityNotFoundException("Company not found for id : " + companyId);
        }
        CompanyDTO companyDTO = companyMapper.toDTO(companyOptional.get());
        return ResponseEntity.ok().body(companyDTO).getBody();
    }

    public CompanyDTO addNewCompany(Company company) {
        Optional<Company> companyOptional = companyRepository
                .findCompanyByName(company.getName());
        if (companyOptional.isPresent()) {
            throw new NameAlreadyExistsException(Const.NAME_ALREADY_EXISTS);
        }
        CompanyDTO companyDTO;
        companyDTO = companyMapper.toDTO(companyRepository.save(company));
        return ResponseEntity.ok().body(companyDTO).getBody();
    }

    public void deleteCompany(Long companyId) {
        boolean exists = companyRepository.existsById(companyId);
        if (!exists) {
            throw new EntityNotFoundException("Company with id " + companyId + " does not exist");
        }
        companyRepository.deleteById(companyId);
    }

    @Transactional
    public CompanyDTO updateCompany(Long companyId, Company company) {
        boolean exists = companyRepository.existsById(companyId);
        CompanyDTO companyDTO;
        if (!exists) {
            throw new EntityNotFoundException("Company with id " + companyId + " does not exist");
        } else {
            companyDTO = companyMapper.toDTO(companyRepository.save(company));
        }
        return ResponseEntity.ok().body(companyDTO).getBody();
    }
}