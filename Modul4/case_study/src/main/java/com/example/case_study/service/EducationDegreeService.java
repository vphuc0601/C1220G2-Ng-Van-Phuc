package com.example.case_study.service;

import com.example.case_study.entity.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(Long id);

    void save(EducationDegree educationDegree);

    void remove(Long id);
}
