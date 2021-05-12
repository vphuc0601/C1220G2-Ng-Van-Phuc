package com.example.book.repositories;

import com.example.book.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderBook,Long> {
}
