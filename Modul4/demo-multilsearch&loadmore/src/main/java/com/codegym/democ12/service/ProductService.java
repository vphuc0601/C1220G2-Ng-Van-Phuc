package com.codegym.democ12.service;

import com.codegym.democ12.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAll(String name_product, Long id_type_product, Double priceFrom, Double priceTo, int index);

    Product findById(Long id);
}
