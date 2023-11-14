package com.vacationRequest.controller;

import com.vacationRequest.domain.Product;
import com.vacationRequest.dto.ProductDTO;
import com.vacationRequest.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/product")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "/product/{productId}")
    public ProductDTO getProductById(@PathVariable("productId") Long productId){
        return productService.getProductById(productId);
    }

    @PostMapping(path = "/product")
    public ProductDTO newProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }

    @DeleteMapping(path = "/product/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "/product/{productId}")
    public ProductDTO updateProduct(
            @PathVariable("productId") Long productId,
            @RequestBody Product product){
        return productService.updateProduct(productId, product);
    }
}