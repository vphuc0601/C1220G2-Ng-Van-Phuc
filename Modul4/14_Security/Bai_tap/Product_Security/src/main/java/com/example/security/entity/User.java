package com.example.security.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", columnDefinition = "VARCHAR(60)")
    private String username;

    @Column(name = "password", columnDefinition = "VARCHAR(75)")
    private String password;

    @Column(name = "enable", columnDefinition = "BIT")
    private boolean enable;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name = "user_id")
            ,inverseJoinColumns =@JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
