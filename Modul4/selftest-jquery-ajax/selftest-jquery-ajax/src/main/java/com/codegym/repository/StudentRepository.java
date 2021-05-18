package com.codegym.repository;

import com.codegym.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Page<Student> findAllByNameContaining(Pageable pageable, String name);

//    @Query(value = "select * from student where `name` like %?1%", nativeQuery = true)
    @Query(value = "select * from student where `name` like concat('%', ?1, '%')", nativeQuery = true)
    List<Student> searchStudentByName(String name);
}
