package com.beagracia.productservice.service;

import com.beagracia.productservice.dto.ProductRequest;
import com.beagracia.productservice.dto.ProductResponse;
import com.beagracia.productservice.model.Product;
import com.beagracia.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::productResponseMap).toList();
    }

    ProductResponse productResponseMap(Product product) {
        return ProductResponse.builder()
                .withId(product.getId())
                .withName(product.getName())
                .withDescription(product.getDescription())
                .withPrice(product.getPrice())
                .build();
    }
}
