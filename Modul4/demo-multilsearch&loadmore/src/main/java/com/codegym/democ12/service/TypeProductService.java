package com.codegym.democ12.service;

import com.codegym.democ12.entity.TypeProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeProductService {

    List<TypeProduct> findAll();

    TypeProduct findById( Long id);
}
