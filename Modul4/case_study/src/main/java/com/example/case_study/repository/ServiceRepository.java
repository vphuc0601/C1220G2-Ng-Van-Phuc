package com.example.case_study.repository;


import com.example.case_study.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    @Query("SELECT p FROM Service p WHERE CONCAT(p.name, p.maxPeople) LIKE %?1%")
    public Page<Service> search(String keyword, Pageable pageable);
}
