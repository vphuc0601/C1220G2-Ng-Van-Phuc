package com.example.case_study.service.impl;


import com.example.case_study.entity.Customer;
import com.example.case_study.repository.CustomerRepository;
import com.example.case_study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> searchCustomer(String keyword, Pageable pageable) {
        return customerRepository.search(keyword,pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByInputText(String inputSearch, Pageable pageable) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

//    @Override
//    public Page<Customer> findByInputText(String inputSearch, Pageable pageable) {
//        return customerRepository.findByName(inputSearch,pageable);
//    }
}
