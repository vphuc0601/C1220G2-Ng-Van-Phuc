package com.blog.blog_manager.service.impl;

import com.blog.blog_manager.model.Blog;
import com.blog.blog_manager.repositories.BlogRepository;
import com.blog.blog_manager.service.BlogService;
import com.blog.blog_manager.ulltil.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() == null) {
            blog.setDate(DateUtil.getCurrentDate());
        }
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }
}




