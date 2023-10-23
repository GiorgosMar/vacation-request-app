package com.example.demo.service;

import com.example.demo.domain.EmployeeProduct;
import com.example.demo.domain.Product;
import com.example.demo.dto.EmployeeProductDTO;
import com.example.demo.repository.EmployeeProductRepository;
import com.example.demo.service.mapper.EmployeeProductMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeProductService {
    private final EmployeeProductRepository employeeProductRepository;
    private final EmployeeProductMapper employeeProductMapper;

    public EmployeeProductService(EmployeeProductRepository employeeProductRepository, EmployeeProductMapper employeeProductMapper) {
        this.employeeProductRepository = employeeProductRepository;
        this.employeeProductMapper = employeeProductMapper;
    }
    public List<EmployeeProductDTO> getAllEmployeeProducts(){
        List<EmployeeProduct> employeeProductList = employeeProductRepository.findAll();
        List<EmployeeProductDTO> employeeProductDTOList= employeeProductMapper.toDTO(employeeProductList);
        return ResponseEntity.ok().body(employeeProductDTOList).getBody();
    }
    public EmployeeProductDTO getEmployeeProductById(Long employeeProductId){
        Optional<EmployeeProduct> employeeProductOptional = employeeProductRepository.findById(employeeProductId);
        if(employeeProductOptional.isEmpty()){
            throw new EntityNotFoundException("Employee product not found for id : " + employeeProductId);
        }
        EmployeeProductDTO employeeProductDTO = employeeProductMapper.toDTO(employeeProductOptional.get());
        return ResponseEntity.ok().body(employeeProductDTO).getBody();
    }
    public Map<String, List<Product>> getEmployeeProductsByCompany(Long companyId) {
        List<EmployeeProduct> employeeProducts = employeeProductRepository.findAllByEmployeeCompanyId(companyId);
        Map<String, List<Product>> productMap = new HashMap<>();
        for (EmployeeProduct employeeProduct : employeeProducts) {
            String employeeKey = employeeProduct.getEmployee().getName() + " " + employeeProduct.getEmployee().getSurname();
            Product product = employeeProduct.getProduct();
        /*
        is a method call on the productMap. It checks if there's already an entry in the map for the given
        'employeeKey'. If there is an entry, it returns the list of products, otherwise it creates a new entry
        with an empty list.
        .add(product) is used to add the current 'product' to the list with me 'employeeKey'
         */
            productMap.computeIfAbsent(employeeKey, k -> new ArrayList<>()).add(product);
        }
        return ResponseEntity.ok().body(productMap).getBody();
    }
    public EmployeeProductDTO addNewEmployeeProduct(EmployeeProduct employeeProduct) {
        EmployeeProductDTO employeeProductDTO;
        employeeProductDTO = employeeProductMapper.toDTO(employeeProductRepository.save(employeeProduct));
        return ResponseEntity.ok().body(employeeProductDTO).getBody();
    }
    public void deleteEmployeeProduct(Long employeeProductId) {
        boolean exists = employeeProductRepository.existsById(employeeProductId);
        if(!exists){
            throw new EntityNotFoundException("Employee product with id " + employeeProductId + " does not exist");
        }
        employeeProductRepository.deleteById(employeeProductId);
    }
    @Transactional
    public EmployeeProductDTO updateEmployeeProduct(Long employeeProductId, EmployeeProduct employeeProduct) {
        boolean exists = employeeProductRepository.existsById(employeeProductId);
        EmployeeProductDTO employeeProductDTO;
        if(!exists){
            throw new EntityNotFoundException("Employee product with id " + employeeProductId + " does not exist");
        }else{
            employeeProductDTO = employeeProductMapper.toDTO(employeeProductRepository.save(employeeProduct));
        }
        return ResponseEntity.ok().body(employeeProductDTO).getBody();
    }
}
