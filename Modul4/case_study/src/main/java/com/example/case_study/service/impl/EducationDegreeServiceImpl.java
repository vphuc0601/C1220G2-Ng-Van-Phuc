package com.example.case_study.service.impl;


import com.example.case_study.entity.EducationDegree;
import com.example.case_study.repository.EducationDegreeRepository;
import com.example.case_study.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Long id) {
        return educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void remove(Long id) {
        educationDegreeRepository.deleteById(id);
    }
}
