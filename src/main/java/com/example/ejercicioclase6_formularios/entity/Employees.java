package com.example.ejercicioclase6_formularios.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @Column(name = "employee_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date", nullable = false)
    private LocalDateTime hireDate;
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Jobs job;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "commission_pct")
    private Double commissionPct;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;
    @Column(name = "enabled")
    private Integer enabled;
}
