package com.example.book.service.impl;

import com.example.book.model.OrderBook;
import com.example.book.repositories.OrderBookRepository;
import com.example.book.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderBookServiceImpl implements OrderBookService {
    @Autowired
    OrderBookRepository orderBookRepository;

    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public OrderBook findById(long id) {
        return orderBookRepository.findById(id).orElse(null);
    }

    @Override
    public Long createId() {
        long code = 0;
        do {
            code = Math.round(Math.random()*100000);
        }while (code < 10000);
        return code;
    }

    @Override
    public void delete(OrderBook orderBook) {
        orderBookRepository.delete(orderBook);
    }

    @Override
    public boolean isEmpty(OrderBook orderBook) {
        return orderBookRepository.existsById(orderBook.getId());
    }
}
