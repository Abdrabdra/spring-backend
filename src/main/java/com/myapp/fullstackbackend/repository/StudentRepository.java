package com.myapp.fullstackbackend.repository;

import com.myapp.fullstackbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
