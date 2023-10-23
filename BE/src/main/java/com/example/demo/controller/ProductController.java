package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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