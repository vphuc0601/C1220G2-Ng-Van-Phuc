package com.example.case_study.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long id;
    @Column(name = "attach_service_name", columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(name = "attach_service_cost", columnDefinition = "DOUBLE")
    private String cost;
    @Column(name = "attach_service_unit", columnDefinition = "VARCHAR(10)")
    private String unit;
    @Column(name = "attach_service_status", columnDefinition = "VARCHAR(255)")
    private String status;



    public AttachService() {
    }

    public AttachService(Long id, String name, String cost, String unit, String status) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
