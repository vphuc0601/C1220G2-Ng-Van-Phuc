package com.example.blog.service;

import com.example.blog.entity.Blog;
import com.example.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(long id);

    void save(Blog blog);

    void remove(Long id);

    Page<Blog> searchInTitle(String title, Pageable pageable);

    Page<Blog> findByCategory(Category category, Pageable pageable);

    Page<Blog> sortByTitleDesc(Pageable pageable);
}
