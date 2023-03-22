package com.beagracia.productservice.service;

import com.beagracia.productservice.dto.ProductDto;
import com.beagracia.productservice.model.Product;
import com.beagracia.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductDto productDto) {
        Product product = Product.builder()
                .withName(productDto.getName())
                .withDescription(productDto.getDescription())
                .withPrice(productDto.getPrice())
                .build();
        productRepository.save(product);
    }
}
