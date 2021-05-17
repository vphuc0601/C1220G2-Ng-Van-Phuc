package com.example.security.service;


import com.example.security.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> searchProduct(String keyword, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
    void save(Product product);
    Product findById(Long id);
    void remove(Long id);
    Product findProductByName(String name);
}
