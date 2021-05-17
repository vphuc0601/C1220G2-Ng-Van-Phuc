package com.blog.demo.service;

import com.blog.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);

    List<Category> findAll();
}
