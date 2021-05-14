package com.example.product_manager.services.impl;

import com.example.product_manager.entity.ProductOrder;
import com.example.product_manager.repository.ProductOrderRepository;
import com.example.product_manager.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Override
    public Page<ProductOrder> searchProductOrder(String keyword, Pageable pageable) {
        return productOrderRepository.searchProductOrder(keyword, pageable);
    }

    @Override
    public Page<ProductOrder> findAllByKey(String keyword, Pageable pageable) {
        return productOrderRepository.findAllByKey(keyword,pageable);
    }

    @Override
    public Page<ProductOrder> findAll(Pageable pageable) {
        return productOrderRepository.findAll(pageable);
    }

    @Override
    public void save(ProductOrder productOrder) {
        productOrderRepository.save(productOrder);
    }

    @Override
    public ProductOrder findById(Long id) {
        return productOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        productOrderRepository.deleteById(id);
    }

    @Override
    public Page<ProductOrder> findAllByKeyword(String keyword1, String keyword2, Pageable pageable) {
        return productOrderRepository.findAllByKeyword(keyword1, keyword2, pageable);
    }

    @Override
    public Page<ProductOrder> findByAll(String keyword1, String keyword2, Pageable pageable) {
        return productOrderRepository.findByAll(keyword1, keyword2, pageable);
    }
}
