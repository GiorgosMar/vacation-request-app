package com.vacationRequest.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Users implements UserDetails {
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

    @JoinColumn(name = "employee_id")
    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserRole> userRole;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> result = new ArrayList<>();
        for(UserRole role : userRole){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRole().getDescription());
            result.add(simpleGrantedAuthority);
        }
        return result;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
