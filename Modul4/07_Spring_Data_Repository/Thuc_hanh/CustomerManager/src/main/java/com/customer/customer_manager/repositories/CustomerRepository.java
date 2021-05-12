package com.customer.customer_manager.repositories;

import com.customer.customer_manager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByNameContaining(String name);
    Page<Customer> findAll(Pageable pageable);
//    List<Customer> findAllByProvinceId(Integer id);
}
