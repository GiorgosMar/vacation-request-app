package com.vacationRequest.service.mapper;

import com.vacationRequest.domain.EmployeeProduct;
import com.vacationRequest.dto.EmployeeProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProductMapper {
    public EmployeeProductDTO toDTO(EmployeeProduct employeeProduct) {
        EmployeeProductDTO employeeProductDTO = new EmployeeProductDTO();
        employeeProductDTO.setId(employeeProduct.getId());
        employeeProductDTO.setEmployee(employeeProduct.getEmployee());
        employeeProductDTO.setProduct(employeeProduct.getProduct());
        return employeeProductDTO;
    }

    public EmployeeProduct toEntity(EmployeeProductDTO employeeProductDTO) {
        EmployeeProduct employeeProduct = new EmployeeProduct();
        employeeProduct.setId(employeeProductDTO.getId());
        employeeProduct.setEmployee(employeeProductDTO.getEmployee());
        employeeProduct.setProduct(employeeProductDTO.getProduct());
        return employeeProduct;
    }

    public List<EmployeeProductDTO> toDTO(List<EmployeeProduct> employeeProductList) {
        List<EmployeeProductDTO> employeeProductDTOList = new ArrayList<>();
        for (EmployeeProduct employeeProduct : employeeProductList) {
            EmployeeProductDTO employeeProductDTO = toDTO(employeeProduct);
            employeeProductDTOList.add(employeeProductDTO);
        }
        return employeeProductDTOList;
    }

    public List<EmployeeProduct> toEntity(List<EmployeeProductDTO> employeeProductDTOList) {
        List<EmployeeProduct> employeeProductList = new ArrayList<>();
        for (EmployeeProductDTO employeeProductDTO : employeeProductDTOList) {
            EmployeeProduct employeeProduct = toEntity(employeeProductDTO);
            employeeProductList.add(employeeProduct);
        }
        return employeeProductList;
    }
}
