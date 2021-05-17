package com.blog.demo.controller;

import com.blog.demo.model.Blog;
import com.blog.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping({"","/"})
    public ModelAndView listBlog(Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<Blog> blogList;
        if (search.isPresent()) {
            blogList = blogService.findAllByFirstNameContaining(search.get(), pageable);
        }else {
            blogList = blogService.findAll(pageable);
        }
        return new ModelAndView("blog/list", "blogList", blogList);
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("blog/create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blog/";
    }
    @GetMapping("/search")
    public String searchBlog(Model model, @RequestParam Optional<String> keyword, Pageable pageable){
        if (!keyword.isPresent()) {
            model.addAttribute("blogs", blogService.findAll(pageable));
            return "blog/list";
        } else {
            String keywordOld = keyword.get();
            model.addAttribute("blogs", blogService.findAllByFirstNameContaining(keywordOld, pageable));
            return "blog/list";
        }
    }
}
