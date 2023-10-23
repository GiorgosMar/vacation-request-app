package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @SequenceGenerator(
            name = "seq_employee",
            sequenceName = "seq_employee",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_employee"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "vacation_days")
    private Integer vacationDays;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "employment_type")
    private String employmentType;

    @JoinColumn(name= "company_id")
    @ManyToOne
    private Company company;
}
