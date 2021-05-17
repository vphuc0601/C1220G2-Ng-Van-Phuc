package com.example.security.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity", columnDefinition = "INT")
    private String quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "day_order", columnDefinition = "DATE")
    private String dayOrder;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "day_delivery", columnDefinition = "DATE")
    private String dayDelivery;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "bill",joinColumns = @JoinColumn(name = "product_order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> product;

    public ProductOrder(Long id, String quantity, String dayOrder, String dayDelivery, Set<Product> product) {
        this.id = id;
        this.quantity = quantity;
        this.dayOrder = dayOrder;
        this.dayDelivery = dayDelivery;
        this.product = product;
    }
}
