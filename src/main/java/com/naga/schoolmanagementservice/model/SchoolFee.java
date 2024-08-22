package com.naga.schoolmanagementservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
@Data
public class SchoolFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
