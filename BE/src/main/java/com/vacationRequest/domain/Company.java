package com.vacationRequest.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Company {
   @Id
   @SequenceGenerator(
           name = "seq_company",
           sequenceName = "seq_company",
           allocationSize = 1
   )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "seq_company"
   )
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "address")
   private String address;

   @Column(name = "phone")
   private String phone;
}
