package com.customer.customer_manager.service;

import com.customer.customer_manager.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
    void  delete(int id);
    void update(Customer customer);
}
