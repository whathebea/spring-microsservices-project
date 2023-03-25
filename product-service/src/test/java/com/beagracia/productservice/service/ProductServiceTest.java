package com.beagracia.productservice.service;

import com.beagracia.productservice.dto.ProductRequest;
import com.beagracia.productservice.dto.ProductResponse;
import com.beagracia.productservice.model.Product;
import com.beagracia.productservice.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;

    private Product product;
    private ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setId(0);
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(new BigDecimal(10));

        productRequest = new ProductRequest();
        productRequest.setName("Test Product");
        productRequest.setDescription("Test Description");
        productRequest.setPrice(new BigDecimal(10));
    }

    @Test
    void addProductTest() {
        productService.addProduct(productRequest);
        verify(productRepository).save(product);
    }

    @Test
    void getAllProductsTest() {
        when(productRepository.findAll()).thenReturn(List.of(product));
        List<ProductResponse> productResponses = productService.getAllProducts();
        assertEquals(1, productResponses.size());
        assertEquals(product.getId(), productResponses.get(0).getId());
        assertEquals(product.getName(), productResponses.get(0).getName());
        assertEquals(product.getDescription(), productResponses.get(0).getDescription());
        assertEquals(product.getPrice(), productResponses.get(0).getPrice());
    }


    @Test
    void productResponseMapTest() {
        Product product = Product.builder().withName("Test Product").withDescription("Test Description").withPrice(new BigDecimal(10)).build();
        ProductResponse productResponse = productService.productResponseMap(product);
        assertEquals(product.getId(), productResponse.getId());
        assertEquals(product.getName(), productResponse.getName());
        assertEquals(product.getDescription(), productResponse.getDescription());
        assertEquals(product.getPrice(), productResponse.getPrice());
    }

}