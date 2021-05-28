package com.example.case_study.entity;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "INT")
    private Long id;

    @Column(name = "user_name", columnDefinition = "VARCHAR(20)")
    private String username;
    @Column(name = "password",columnDefinition = "VARCHAR(75)")
    private String password;
    @Column(name = "enable", columnDefinition = "BIT")
    private String enable;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns =@JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String username, String password, String enable, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.roles = roles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
