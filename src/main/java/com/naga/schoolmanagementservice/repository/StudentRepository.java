package com.naga.schoolmanagementservice.repository;

import com.naga.schoolmanagementservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
