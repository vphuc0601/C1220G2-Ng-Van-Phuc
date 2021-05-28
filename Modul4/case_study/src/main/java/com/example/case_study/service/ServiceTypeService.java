package com.example.case_study.service;

import com.example.case_study.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(Long id);

    void save(ServiceType serviceType);

    void remove(Long id);
}
