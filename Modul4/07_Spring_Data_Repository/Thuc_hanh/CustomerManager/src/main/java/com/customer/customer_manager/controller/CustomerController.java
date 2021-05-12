package com.customer.customer_manager.controller;

import com.customer.customer_manager.model.Customer;
import com.customer.customer_manager.model.Province;
import com.customer.customer_manager.service.CustomerService;
import com.customer.customer_manager.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;
    @GetMapping({"","/"})
    public ModelAndView getListCustomer(@PageableDefault(value = 4) Pageable pageable){
//        List<Province> provinces=provinceService.findAll();

        return new ModelAndView ("customer/list","listCustomer",this.customerService.findAll(pageable));
    }
//    @GetMapping("create")
//    public String createCustomer(Model model){
//        model.addAttribute("customer", new Customer());
//        return"/create";
//    }
    @GetMapping("create")
    public ModelAndView getCreatePage(Model model){
        model.addAttribute("provinces",provinceService.findAll());
    return new ModelAndView("customer/create", "customer", new Customer());
}
    @PostMapping("save")
    public String save(Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("provinces",provinceService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "/customer/edit";
    }
    @PostMapping("/customer/update")
    public String update(Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/customer/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirect) {
        customerService.deleteById(id);
        redirect.addFlashAttribute("success", "Removed product success!");
        return "redirect:/";
    }
    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
