package com.example.product_manager.services;

import com.example.product_manager.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAll();
    ProductType findById(Long id);
}
