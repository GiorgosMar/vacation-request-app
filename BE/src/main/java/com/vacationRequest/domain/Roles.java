package com.vacationRequest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @SequenceGenerator(
            name = "seq_role",
            sequenceName = "seq_role",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_role"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "user_role")
    private String description;

    @OneToMany(mappedBy = "role")
    Set<UserRole> userRole;

}
