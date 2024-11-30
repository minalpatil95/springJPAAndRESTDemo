package com.minal.springweb.productrestapi.controllers;

import com.minal.springweb.productrestapi.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductControllerTest {

    @Value("${productrestapi.services.url}")
    private String baseURL;

    @Test
    public void testGetProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(baseURL + "/" +5, Product.class);
        assertNotNull(product);
        assertEquals("IPhone", product.getName());
    }

    @Test
    public void testPostProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = new Product();
        product.setName("IPhone8");
        product.setDescription("IPhone 8");
        product.setPrice(8000);
        Product savedProduct = restTemplate.postForObject(baseURL, product, Product.class);
        assertNotNull(savedProduct);
        assertNotNull(savedProduct.getId());
        assertEquals("IPhone8", savedProduct.getName());
    }

    @Test
    public void testUpdateProduct() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(baseURL+"/"+5, Product.class);
        product.setPrice(10000);
        restTemplate.put(baseURL, product);
    }
}
