package com.blog.demo.controller;

import com.blog.demo.model.Category;
import com.blog.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }



    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") long id) {
        System.out.println("Fetching Category with id " + id);
        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }



    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Category " + category.getName());
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        System.out.println("Updating Customer " + id);

        Category currentCategory = categoryService.findById(id);

        if (currentCategory == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setName(category.getName());
        currentCategory.setId(category.getId());

        categoryService.save(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }



    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Category with id " + id);

        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Unable to delete. Category with id " + id + " not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }

        categoryService.remove(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}
