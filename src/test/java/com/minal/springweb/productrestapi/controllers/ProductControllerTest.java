package com.minal.springweb.productrestapi.controllers;

import com.minal.springweb.productrestapi.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductControllerTest {

    @Test
    public void testGetProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/5", Product.class);
        assertNotNull(product);
        assertEquals("IPhone", product.getName());
    }

    @Test
    public void testPostProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = new Product();
        product.setName("IPhone7");
        product.setDescription("IPhone 7");
        product.setPrice(7000);
        Product savedProduct = restTemplate.postForObject("http://localhost:8080/productapi/products", product, Product.class);
        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals("IPhone7", savedProduct.getName());
    }

    @Test
    public void testUpdateProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject("http://localhost:8080/productapi/products/5", Product.class);
        product.setPrice(10000);
        restTemplate.put("http://localhost:8080/productapi/products", product);
    }
}
