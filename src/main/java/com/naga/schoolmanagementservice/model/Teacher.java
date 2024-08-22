package com.naga.schoolmanagementservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String phone;
    private String department;
    private String hireDate;

    @OneToMany(mappedBy = "teacher")
    private List<Subject> subjects;
}
