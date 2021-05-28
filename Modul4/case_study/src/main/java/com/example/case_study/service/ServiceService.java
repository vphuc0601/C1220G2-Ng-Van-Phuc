package com.example.case_study.service;

import com.example.case_study.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public interface ServiceService  {
    public Page<Service> searchService(String keyword, Pageable pageable);

    Service findById(Long id);

    void save(Service service);

    void remove(Long id);

    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();

    Page<Service> findByInputText(String inputSearch, Pageable pageable);
}
