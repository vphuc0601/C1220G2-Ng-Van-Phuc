package com.example.case_study.repository;
import com.example.case_study.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Long> {
}
