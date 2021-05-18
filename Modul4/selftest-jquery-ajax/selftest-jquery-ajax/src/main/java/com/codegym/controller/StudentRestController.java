package com.codegym.controller;

import com.codegym.entity.Student;
import com.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/apiStudent")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Student>> getListStudent() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer id) throws Exception {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder) {
        this.studentService.save(student);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/student/detail/{id}").buildAndExpand(student.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
