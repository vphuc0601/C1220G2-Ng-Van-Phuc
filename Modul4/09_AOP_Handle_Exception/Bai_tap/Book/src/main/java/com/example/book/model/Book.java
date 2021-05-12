package com.example.book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBook;
    private String content;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<OrderBook> orderBooks;

    public Book() {
    }
}
