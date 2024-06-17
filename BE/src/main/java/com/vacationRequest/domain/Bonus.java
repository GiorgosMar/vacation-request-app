package com.vacationRequest.domain;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "bonus")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Bonus {
    @Id
    @SequenceGenerator(
            name = "seq_bonus",
            sequenceName = "seq_bonus",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_bonus"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @JoinColumn(name = "employee_id")
    @ManyToOne
    private Employee employee;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;

}
