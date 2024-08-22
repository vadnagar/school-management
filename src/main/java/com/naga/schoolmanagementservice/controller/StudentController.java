package com.naga.schoolmanagementservice.controller;

import com.naga.schoolmanagementservice.exception.StudentNotFoundException;
import com.naga.schoolmanagementservice.model.Student;
import com.naga.schoolmanagementservice.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from this origin
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        // Validate if the student with the given id exists
        studentService.getStudentById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Update the student's data
        updatedStudent.setId(id);
        return studentService.saveStudent(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
