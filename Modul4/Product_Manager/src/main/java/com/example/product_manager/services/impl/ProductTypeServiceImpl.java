package com.example.product_manager.services.impl;

import com.example.product_manager.entity.ProductType;
import com.example.product_manager.repository.ProductTypeRepository;
import com.example.product_manager.services.ProductTypeService;
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
