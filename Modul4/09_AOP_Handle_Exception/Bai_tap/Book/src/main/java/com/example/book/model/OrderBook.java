package com.example.book.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class OrderBook {

    @Id
    private long id;
   @ManyToOne
   @JoinColumn(name = "id_book", referencedColumnName = "id")
   private Book book;

    public OrderBook() {
    }
    public OrderBook(long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
