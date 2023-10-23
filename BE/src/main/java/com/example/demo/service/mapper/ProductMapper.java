package com.example.demo.service.mapper;

import com.example.demo.domain.Product;
import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setBarcode(product.getBarcode());
        return productDTO;
    }

    public Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setBarcode(productDTO.getBarcode());
        return product;
    }

    public List<ProductDTO> toDTO(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = toDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    public List<Product> toEntity(List<ProductDTO> productDTOList) {
        List<Product> productList = new ArrayList<>();
        for (ProductDTO productDTO : productDTOList) {
            Product product = toEntity(productDTO);
            productList.add(product);
        }
        return productList;
    }
}
