package com.example.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
@Aspect
public class BookAop {
        @After("execution(* com.example.book.controller.BookController.save(..))")
        public void afterBorrow(JoinPoint joinPoint){
            System.out.println("Add order book success " + joinPoint.getSignature().getName());
        }
        @After("execution(* com.example.book.controller.BookController.viewReturnBook(..))")
        public void afterReturnBook(JoinPoint joinPoint){
            System.out.println("Add return book success " + joinPoint.getSignature().getName());
        }
}
