package com.codegym.democ12.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_product")

public class TypeProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_product")
    private long idTypeProduct;

    @Column(name = "name_type")
    private String nameType;

    @OneToMany(mappedBy = "typeProduct", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> productList;

    public TypeProduct() {
    }

    public long getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(long idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
