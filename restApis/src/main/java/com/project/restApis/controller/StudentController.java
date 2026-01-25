package com.project.restApis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.restApis.dto.StudentDto;
import com.project.restApis.service.StudentService;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    
    @GetMapping("/students")
    public List<StudentDto> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable Long id) {
        return new String();
    }
    
    
}
