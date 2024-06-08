package com.javawebfinal.mapper;

import com.javawebfinal.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMapperTest {
    @Autowired ProductMapper productMapper;
    
    @Test
    void listAllProducts() {
        System.out.println(productMapper.listAllProducts());
    }
    
    @Test
    void updateProductById() {
        productMapper.updateProductById(new Product(20, "brand", "model", 8999, "", "detail"));
    }
    
    @Test
    void addProduct() {
        productMapper.addProduct(new Product(0, "test", "model", 1, "", "detail"));
    }
}