package com.example.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", columnDefinition = "VARCHAR(60)")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users= new HashSet<>();
}
