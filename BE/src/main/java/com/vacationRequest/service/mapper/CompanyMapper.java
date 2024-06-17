package com.vacationRequest.service.mapper;

import com.vacationRequest.domain.Company;
import com.vacationRequest.dto.CompanyDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapper {

    public CompanyDTO toDTO(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setAddress(company.getAddress());
        companyDTO.setPhone(company.getPhone());
        return companyDTO;
    }
    public Company toEntity(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setName(companyDTO.getName());
        company.setAddress(companyDTO.getAddress());
        company.setPhone(companyDTO.getPhone());
        return company;
    }
    public List<CompanyDTO> toDTO(List<Company> companyList) {
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        for (Company company : companyList) {
            CompanyDTO companyDTO = toDTO(company);
            companyDTOList.add(companyDTO);
        }
        return companyDTOList;
    }
    public List<Company> toEntity(List<CompanyDTO> companyDTOList) {
        List<Company> companyList = new ArrayList<>();
        for (CompanyDTO companyDTO : companyDTOList) {
            Company company = toEntity(companyDTO);
            companyList.add(company);
        }
        return companyList;
    }
}
