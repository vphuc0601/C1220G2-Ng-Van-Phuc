package com.blog.blog_manager.controller;

import com.blog.blog_manager.model.Blog;
import com.blog.blog_manager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @GetMapping({"","/"})
    public String getListBlog(Model model){
        model.addAttribute("list",this.blogService.findAll());
        return "home";
    }
    @GetMapping("create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blog());
        return"/create";
    }
    @PostMapping("save")
    public String save(Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }
    @PostMapping("update")
    public String update(Blog blog) {
        blogService.update(blog);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        blogService.delete(id);
        return "redirect:/";
    }

//    @PostMapping("delete")
//    public String delete(@RequestParam int id, RedirectAttributes redirect) {
//        blogService.delete(id);
//        redirect.addFlashAttribute("success", "Removed blog success!");
//        return "redirect:/";
//    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }
}
