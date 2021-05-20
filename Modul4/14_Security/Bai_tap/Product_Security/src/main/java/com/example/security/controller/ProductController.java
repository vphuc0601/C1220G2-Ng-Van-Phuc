package com.example.security.controller;


import com.example.security.entity.Product;
import com.example.security.service.ProductService;
import com.example.security.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping({"", "/"})
    public String goHome() {
        return "home";
    }

    @GetMapping("product")
    public String getListProduct(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> searchName,
                                 Product product, Model model, RedirectAttributes redirectAttributes) {
        String stringAfterCheck = "";
        if (!searchName.isPresent()) {
            model.addAttribute("productList", productService.findAll(pageable));
        } else {
            stringAfterCheck = searchName.get();
            model.addAttribute("productList", productService.searchProduct(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "product/list";
    }

    @GetMapping("product/create")
    public String goFormCreate(Model model) {
        model.addAttribute("productType", productTypeService.findAll());
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("product/create")
    public String createCreateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes, Model model) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("successMsg", "Create Product: " + product.getName() + " success!");
        return "redirect:/product";
    }

    @GetMapping(value = "product/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model) {
        model.addAttribute("productType", productTypeService.findAll());
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping(value = "product/edit")
    public String editCustomer(@ModelAttribute Product product, RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("productType", productTypeService.findAll());
        productService.save(product);
        redirectAttributes.addFlashAttribute("successMsg", "Update Product: " + product.getName() + "success!");
        return "redirect:/product";
    }

    @GetMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/delete";
    }

    @PostMapping(value = "product/delete")
    public String deleteProduct(@RequestParam Long id, RedirectAttributes redirect) {
        productService.remove(id);
        redirect.addFlashAttribute("successMsg", "Delete Product: " + " success!");
        return "redirect:/product";
    }
    @GetMapping("product/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model){
        model.addAttribute("productType", productTypeService.findAll());
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }
    @GetMapping("product/search")
    public ModelAndView searchProduct(@RequestParam String keyword, @PageableDefault(value = 5)Pageable pageable){
        return new ModelAndView("product/list", "productList", productService.searchProduct(keyword, pageable));
    }
    @GetMapping("/403")
    public String error403(){
        return "403";
    }
}
