package com.customer.customer_manager.service.impl;

import com.customer.customer_manager.model.Customer;
import com.customer.customer_manager.repositories.CustomerRepository;
import com.customer.customer_manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.findByNameContaining(name);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }


}
