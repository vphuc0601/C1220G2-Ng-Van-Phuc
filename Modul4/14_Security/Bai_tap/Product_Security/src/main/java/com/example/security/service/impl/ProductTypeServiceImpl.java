package com.example.security.service.impl;


import com.example.security.entity.ProductType;
import com.example.security.repository.ProductTypeRepository;
import com.example.security.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findById(Long id) {
        return productTypeRepository.findById(id).orElse(null);
    }
}
