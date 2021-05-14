package com.example.product_manager.services;

import com.example.product_manager.entity.Product;
import com.example.product_manager.entity.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductOrderService {
    public Page<ProductOrder> searchProductOrder(String keyword, Pageable pageable);
    public Page<ProductOrder> findAllByKey(String keyword, Pageable pageable);
    Page<ProductOrder> findAll(Pageable pageable);
    void save (ProductOrder productOrder);
    ProductOrder findById(Long id);
    void remove(Long id);
    Page<ProductOrder> findAllByKeyword(String keyword1,String keyword2, Pageable pageable);
    Page<ProductOrder> findByAll(String keyword1, String keyword2, Pageable pageable);
}
