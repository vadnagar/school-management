package com.naga.schoolmanagementservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String standard;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String guardianName;
    private String guardianPhone;
    private String guardianEmail;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "student")
    private List<SchoolFee> schoolFees;

    @ManyToMany
    @JoinTable(name = "student_subjects",
            joinColumns = @JoinColumn(name = "student_id"),  // Correcting the column name here
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects = new ArrayList<>();

}