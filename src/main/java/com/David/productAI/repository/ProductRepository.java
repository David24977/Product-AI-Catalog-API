package com.David.productAI.repository;

import com.David.productAI.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByPriceBetweenOrderByPriceAsc(BigDecimal priceMin, BigDecimal priceMax);
}
