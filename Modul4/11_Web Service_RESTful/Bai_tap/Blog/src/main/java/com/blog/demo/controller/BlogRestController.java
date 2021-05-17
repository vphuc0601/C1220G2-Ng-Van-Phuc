package com.blog.demo.controller;

import com.blog.demo.model.Blog;
import com.blog.demo.model.Category;
import com.blog.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "/blog/", method = RequestMethod.GET)
    public HttpEntity<? extends List<? extends Object>> listAllBlog() {
        List<Blog> blog = blogService.findAll();
        if (blog.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
    }



    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<? extends Object> getBlog(@PathVariable("id") long id) {
        System.out.println("Fetching Blog with id " + id);
        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("blog with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }



    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Blog " + blog.getContent());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    @RequestMapping(value = "/blog/{id}", method = RequestMethod.PUT)
    public ResponseEntity<? extends Object> updateBlog(@PathVariable("id") long id, @RequestBody Blog blog) {
        System.out.println("Updating Blog " + id);

        Blog currentBlog = blogService.findById(id);

        if (currentBlog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setContent(blog.getContent());
        currentBlog.setId(blog.getId());

        blogService.save(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }



    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<? extends Object> deleteBlog(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Blog blog = blogService.findById(id);
        if (blog == null) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }
}
