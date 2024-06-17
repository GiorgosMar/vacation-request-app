package com.vacationRequest.service;

import com.vacationRequest.domain.Product;
import com.vacationRequest.dto.ProductDTO;
import com.vacationRequest.repository.ProductRepository;
import com.vacationRequest.service.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    public List<ProductDTO> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = productMapper.toDTO(productList);
        return ResponseEntity.ok().body(productDTOList).getBody();
    }
    public ProductDTO getProductById(Long productId){
        Optional<Product> productOptional = productRepository.findById(productId);
        if(productOptional.isEmpty()){
            throw new EntityNotFoundException("Product not found for id : " + productId);
        }
        ProductDTO productDTO = productMapper.toDTO(productOptional.get());
        return ResponseEntity.ok().body(productDTO).getBody();
    }
    public ProductDTO addNewProduct(Product product) {
        ProductDTO productDTO;
        productDTO = productMapper.toDTO(productRepository.save(product));
        return ResponseEntity.ok().body(productDTO).getBody();
    }
    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if(!exists){
            throw new EntityNotFoundException("Product with id " + productId + " does not exist");
        }
        productRepository.deleteById(productId);
    }
    @Transactional
    public ProductDTO updateProduct(Long productId, Product product) {
        boolean exists = productRepository.existsById(productId);
        ProductDTO productDTO;
        if(!exists){
            throw new EntityNotFoundException("Product with id " + productId + " does not exist");
        }else{
            productDTO = productMapper.toDTO(productRepository.save(product));
        }
        return ResponseEntity.ok().body(productDTO).getBody();
    }
}
