package com.example.book.service;

import com.example.book.aop.BookAop;
import com.example.book.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AopConfig {
    @Bean
    public BookServiceImpl bookService(){
        return new BookServiceImpl();
    }
    @Bean
    public BookAop bookAop(){
        return  new BookAop();
    }
}
