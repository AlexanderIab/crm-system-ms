package com.iablonski.crm.user.service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UserRole role;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}