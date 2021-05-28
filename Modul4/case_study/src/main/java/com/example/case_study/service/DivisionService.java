package com.example.case_study.service;

import com.example.case_study.entity.Division;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();

    Division findById(Long id);

    void save(Division division);

    void remove(Long id);
}
