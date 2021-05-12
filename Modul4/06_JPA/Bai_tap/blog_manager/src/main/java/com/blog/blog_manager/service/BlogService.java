package com.blog.blog_manager.service;

import com.blog.blog_manager.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void  delete(int id);
    void update(Blog blog);
}
