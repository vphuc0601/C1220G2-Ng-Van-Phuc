package com.example.case_study.service.impl;

import com.example.case_study.entity.AttachService;
import com.example.case_study.repository.AttachServiceRepository;
import com.example.case_study.service.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(Long id) {
        return attachServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Long id) {
        attachServiceRepository.deleteById(id);
    }
}
