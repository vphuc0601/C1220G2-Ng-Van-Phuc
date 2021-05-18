package com.codegym.service.impl;

import com.codegym.entity.Student;
import com.codegym.repository.StudentRepository;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
//        return this.studentRepository.findAllByNameContainingOrderByIdDesc("a");
//        return this.studentRepository.searchStudentByName("a");
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return this.studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(Integer id) throws Exception {
        Student object = this.studentRepository.findById(id).orElse(null);

        if (object == null) {
            throw new Exception("Khong tim thay thong tin hoc vien");
        }

        return object;
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Page<Student> findByNameContaining(Pageable pageable, String name) {
        return this.studentRepository.findAllByNameContaining(pageable, name);
    }
}
