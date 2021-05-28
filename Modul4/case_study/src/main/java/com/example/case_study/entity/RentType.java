package com.example.case_study.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rent_type_name", columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(name = "rent_type_cost", columnDefinition = "DOUBLE")
    private Double cost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private Set<Service> services;

    public RentType() {
    }

    public RentType(Long id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
