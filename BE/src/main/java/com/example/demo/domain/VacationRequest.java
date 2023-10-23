package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "vacation_request")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VacationRequest {
    @Id
    @SequenceGenerator(
            name = "vacation_request_seq",
            sequenceName = "vacation_request_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vacation_request_seq"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status")
    private String status;

    @Column(name = "days")
    private Integer days;

    @JoinColumn(name = "employee_id")
    @ManyToOne
    private Employee employee;
}
