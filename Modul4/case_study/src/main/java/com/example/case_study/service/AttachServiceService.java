package com.example.case_study.service;



import com.example.case_study.entity.AttachService;

import java.util.List;

public interface AttachServiceService {
    List<AttachService> findAll();

    AttachService findById(Long id);

    void save(AttachService attachService);

    void remove(Long id);
}
