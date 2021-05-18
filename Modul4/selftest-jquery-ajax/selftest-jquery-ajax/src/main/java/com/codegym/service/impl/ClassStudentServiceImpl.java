package com.codegym.service.impl;

import com.codegym.entity.ClassStudent;
import com.codegym.repository.ClassStudentRepository;
import com.codegym.service.ClassStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStudentServiceImpl implements ClassStudentService {
    @Autowired
    private ClassStudentRepository classStudentRepository;

    @Override
    public List<ClassStudent> findAll() {
        return this.classStudentRepository.findAll();
    }
}
