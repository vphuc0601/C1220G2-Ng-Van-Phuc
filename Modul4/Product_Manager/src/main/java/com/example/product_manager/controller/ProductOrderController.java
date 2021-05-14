package com.example.product_manager.controller;

import com.example.product_manager.entity.Product;
import com.example.product_manager.entity.ProductOrder;
import com.example.product_manager.services.ProductOrderService;
import com.example.product_manager.services.ProductService;
import com.example.product_manager.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductOrderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductOrderService productOrderService;


    @GetMapping("productOrder")
    public String getListProduct(@PageableDefault(size = 5) Pageable pageable, @RequestParam Optional<String> searchName,
                                 ProductOrder productOrder, Model model, RedirectAttributes redirectAttributes) {
        String stringAfterCheck = "";
        if (!searchName.isPresent()) {
            model.addAttribute("product", productService.findAll());
            model.addAttribute("productType", productTypeService.findAll());
            model.addAttribute("productOrderList", productOrderService.findAll(pageable));
        } else {
            stringAfterCheck = searchName.get();
            model.addAttribute("product", productService.findAll());
            model.addAttribute("productType", productTypeService.findAll());
            model.addAttribute("productOrderList", productOrderService.searchProductOrder(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "productOrder/list";
    }

    @GetMapping("productOrder/create")
    public String goFormCreate(Model model) {
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("productType", productTypeService.findAll());
        model.addAttribute("productOrder", new ProductOrder());
        return "productOrder/create";
    }

    @PostMapping("productOrder/create")
    public String createCreateProduct(@ModelAttribute ProductOrder productOrder, RedirectAttributes redirectAttributes, Model model) {
//        productOrder.getProduct().add(productOrder)
        productOrderService.save(productOrder);
        redirectAttributes.addFlashAttribute("successMsg", "Create ProductOrder: "  + " success!");
        return "redirect:/productOrder";
    }
//
//    @GetMapping(value = "product/edit/{id}")
//    public String showEditPage(@PathVariable Long id, Model model) {
//        model.addAttribute("productType", productTypeService.findAll());
//        model.addAttribute("product", productService.findById(id));
//        return "product/edit";
//    }
//
//    @PostMapping(value = "product/edit")
//    public String editCustomer(@ModelAttribute Product product, RedirectAttributes redirectAttributes, Model model) {
//        model.addAttribute("productType", productTypeService.findAll());
//        productService.save(product);
//        redirectAttributes.addFlashAttribute("successMsg", "Update Product: " + product.getName() + "success!");
//        return "redirect:/product";
//    }
//
    @GetMapping("productOrder/delete/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        model.addAttribute("productOrder", productOrderService.findById(id));
        return "productOrder/delete";
    }

    @PostMapping(value = "productOrder/delete")
    public String deleteProduct(@RequestParam Long id, RedirectAttributes redirect) {
        productOrderService.remove(id);
        redirect.addFlashAttribute("successMsg", "Delete ProductOrder: " + " success!");
        return "redirect:/productOrder";
    }
//    @GetMapping("product/view/{id}")
//    public String viewProduct(@PathVariable Long id, Model model){
//        model.addAttribute("productType", productTypeService.findAll());
//        model.addAttribute("product", productService.findById(id));
//        return "product/view";
//    }
    @GetMapping("productOrder/search")
    public String searchProductOrder(@RequestParam String keyword1, String keyword2,@PageableDefault(size = 4) Pageable pageable,Model model){
        model.addAttribute("product", productService.findAll());
        model.addAttribute("productType", productTypeService.findAll());
//        model.addAttribute("productOrderList", productOrderService.findAllByKey(keyword, pageable));
        model.addAttribute("productOrderList", productOrderService.findByAll(keyword1, keyword2, pageable));
        return "productOrder/list";
    }
}
