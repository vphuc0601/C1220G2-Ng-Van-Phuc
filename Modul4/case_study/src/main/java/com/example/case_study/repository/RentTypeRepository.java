package com.example.case_study.repository;


import com.example.case_study.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType,Long> {
}
