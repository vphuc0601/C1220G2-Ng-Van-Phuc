package com.codegym.democ12.service.impl;

import com.codegym.democ12.entity.TypeProduct;
import com.codegym.democ12.repositories.TypeProductRepository;
import com.codegym.democ12.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductServiceImpl implements TypeProductService {

    @Autowired
    private TypeProductRepository typeProductRepository;

    @Override
    public List<TypeProduct> findAll() {
        return typeProductRepository.findAll();
    }

    @Override
    public TypeProduct findById(Long id) {
        return typeProductRepository.findById(id).orElse(null);
    }
}
