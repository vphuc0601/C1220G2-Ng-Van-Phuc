package com.example.case_study.service.impl;

import com.example.case_study.entity.Service;
import com.example.case_study.repository.ServiceRepository;
import com.example.case_study.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service

public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findByInputText(String inputSearch, Pageable pageable) {
        return null;
    }


    @Override
    public Page<Service> searchService(String keyword, Pageable pageable) {
        return serviceRepository.search(keyword,pageable);
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }
}
