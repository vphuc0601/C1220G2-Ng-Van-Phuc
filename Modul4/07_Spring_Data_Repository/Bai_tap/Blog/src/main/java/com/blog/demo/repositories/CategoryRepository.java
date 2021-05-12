package com.blog.demo.repositories;

import com.blog.demo.model.Blog;
import com.blog.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Page<Category> findAllByContentContaining(String content, Pageable pageable);
}
