package com.minal.springweb.productrestapi.repositories;

import com.minal.springweb.productrestapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
