package com.example.case_study.service;

import com.example.case_study.entity.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(long id);
}
