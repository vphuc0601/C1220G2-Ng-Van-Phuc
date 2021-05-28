package com.example.case_study.service;

import com.example.case_study.entity.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentTypeService {
    List<RentType> findAll();

    RentType findById(Long id);

    void save(RentType rentType);

    void remove(Long id);


}
