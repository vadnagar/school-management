package com.naga.schoolmanagementservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date attendanceDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
