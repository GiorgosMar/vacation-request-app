package com.vacationRequest.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users {
    @Id
    @SequenceGenerator(
            name = "seq_user",
            sequenceName = "seq_user",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_user"
    )
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

    @JoinColumn(name = "employee_id")
    @ManyToOne
    private Employee employee;


}
