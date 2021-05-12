package com.example.book.service;

import com.example.book.model.OrderBook;

public interface OrderBookService {
    void save(OrderBook orderBook);
    OrderBook findById(long id);
    Long createId();
    void delete(OrderBook orderBook);
    boolean isEmpty(OrderBook orderBook);
}
