package com.blog.demo.service.impl;

import com.blog.demo.model.Blog;
import com.blog.demo.repositories.BlogRepository;
import com.blog.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByFirstNameContaining(String search, Pageable pageable) {
        return blogRepository.findAllByContentContaining("search", pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}
