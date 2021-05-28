package com.example.case_study.service;

import com.example.case_study.entity.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(Long id);

    void save(CustomerType customerType);

    void remove(Long id);

}
