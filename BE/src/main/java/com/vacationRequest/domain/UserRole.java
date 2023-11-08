package com.vacationRequest.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "userrole")
public class UserRole {
    @Id
    @SequenceGenerator(
            name = "seq_user_role",
            sequenceName = "seq_user_role",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_user_role"
    )
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    Roles role;

}
