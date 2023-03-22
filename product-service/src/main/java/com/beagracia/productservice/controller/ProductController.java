package com.beagracia.productservice.controller;

import com.beagracia.productservice.dto.ProductRequest;
import com.beagracia.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addNewProduct/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewProduct(@RequestBody ProductRequest productRequest) {
        productService.addProduct(productRequest);
    }
}
