package com.customer.customer_manager.service;

import com.customer.customer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    void deleteById(int id);
    void save(Customer customer);
    List<Customer> searchByName(String name);
    void update(Customer customer);
}
