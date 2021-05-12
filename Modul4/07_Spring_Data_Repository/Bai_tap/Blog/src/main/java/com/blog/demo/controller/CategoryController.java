package com.blog.demo.controller;

import com.blog.demo.model.Category;
import com.blog.demo.service.BlogService;
import com.blog.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping
    public String listCategories(@PageableDefault(value = 2) Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.findAll(pageable));
        model.addAttribute("category", new Category());
        return "category/list";
    }

    @GetMapping("/save")
    public String save(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("message", "Saved category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, @PageableDefault(value = 2) Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.findAll(pageable));
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirect) {
        categoryService.remove(id);
        redirect.addFlashAttribute("message", "Removed category successfully!");
        return "redirect:/category";
    }

//    @GetMapping("/blogs")
//    public String view(@RequestParam Long id, @PageableDefault(value = 2) Pageable pageable, Model model) {
//        Category category = categoryService.findById(id);
//        model.addAttribute("categories", categoryService.findAll(pageable));
//        model.addAttribute("category", category);
//        model.addAttribute("blogs", blogService.findByCategory(category, pageable));
//        return "category/view";
//    }
}
