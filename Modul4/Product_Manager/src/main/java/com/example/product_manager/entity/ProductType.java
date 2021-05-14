package com.example.product_manager.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_type",columnDefinition = "VARCHAR(255)")
    private String name;

    @OneToMany(mappedBy = "productType",cascade = CascadeType.ALL)
    private List<Product> products;
}
