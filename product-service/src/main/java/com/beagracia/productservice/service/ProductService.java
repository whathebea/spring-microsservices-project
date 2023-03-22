package com.beagracia.productservice.service;

import com.beagracia.productservice.dto.ProductRequest;
import com.beagracia.productservice.model.Product;
import com.beagracia.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .withName(productRequest.getName())
                .withDescription(productRequest.getDescription())
                .withPrice(productRequest.getPrice())
                .build();
        productRepository.save(product);
    }
}
