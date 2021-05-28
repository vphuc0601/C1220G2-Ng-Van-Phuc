package com.example.case_study.repository;

import com.example.case_study.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
