package com.project.restApis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.restApis.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
