package com.example.case_study.repository;


import com.example.case_study.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT p FROM Employee p WHERE CONCAT(p.employeeName, p.employeeBirthday) LIKE %?1%")
    public Page<Employee> search(String keyword, Pageable pageable);
}
