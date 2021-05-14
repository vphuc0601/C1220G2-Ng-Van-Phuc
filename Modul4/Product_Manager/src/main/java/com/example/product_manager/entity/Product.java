package com.example.product_manager.entity;

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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", columnDefinition = "VARCHAR(255)")
    private String name;
    @Column(name = "manufacturer", columnDefinition = "VARCHAR(255)")
    private String manufacture;
    @Column(name = "price", columnDefinition = "DOUBLE")
    private String price;
    
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    private ProductType productType;

    @ManyToMany(mappedBy = "product")
    private Set<ProductOrder> productOrders;

    public Product(Long id, String name, String manufacture, String price, ProductType productType, Set<ProductOrder> productOrders) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.price = price;
        this.productType = productType;
        this.productOrders = productOrders;
    }

    public String getName() {
        return name;
    }
}
