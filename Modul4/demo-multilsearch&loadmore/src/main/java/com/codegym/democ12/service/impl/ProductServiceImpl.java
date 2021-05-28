package com.codegym.democ12.service.impl;

import com.codegym.democ12.entity.Product;
import com.codegym.democ12.repositories.ProductRepository;
import com.codegym.democ12.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll(String name_product, Long id_type_product, Double priceFrom, Double priceTo, int index) {
        return productRepository.searchAdvance(name_product, id_type_product, priceFrom, priceTo, index);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
