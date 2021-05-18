package com.codegym.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity (name = "class")
public class ClassStudent {

    @Id
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "classStudent", cascade = CascadeType.ALL)
    private List<Student> studentList;

    public ClassStudent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
