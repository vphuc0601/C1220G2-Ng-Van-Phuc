package com.example.security.service;


import com.example.security.entity.ProductType;

import java.util.List;

public interface ProductTypeService {
    List<ProductType> findAll();
    ProductType findById(Long id);
}
