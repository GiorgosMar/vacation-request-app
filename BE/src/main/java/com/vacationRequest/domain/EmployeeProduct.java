package com.vacationRequest.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeProduct {
    @Id
    @SequenceGenerator(
            name = "employee_product_seq",
            sequenceName = "employee_product_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_product_seq"
    )
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "employee_id")
    @ManyToOne
    private Employee employee;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
}
