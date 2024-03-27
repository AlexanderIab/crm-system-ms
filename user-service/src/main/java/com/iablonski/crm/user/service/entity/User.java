package com.iablonski.crm.user.service.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users", schema = "user-service", catalog = "crm")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ToString.Include(name = "password")
    private String maskPassword() {
        return "********";
    }
}
