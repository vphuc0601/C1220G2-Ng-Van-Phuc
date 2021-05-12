package com.customer.customer_manager.service;

import com.customer.customer_manager.model.Customer;
import com.customer.customer_manager.model.Province;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProvinceService {
    List<Province> findAll();
    Province  findById(Integer id);
}
