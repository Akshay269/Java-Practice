package com.project.restApis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.restApis.dto.StudentDto;
import com.project.restApis.repository.StudentRepository;
import com.project.restApis.service.StudentService;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }
}
