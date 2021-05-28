package com.example.case_study.controller;
import com.example.case_study.entity.Customer;
import com.example.case_study.service.CustomerService;
import com.example.case_study.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @GetMapping({"","/"})
    public String goHome(){
        return "home";
    }

    @GetMapping("customer")
    public String getAllCustomer(@PageableDefault(size = 4) Pageable pageable,
                                 @RequestParam Optional<String> searchNameCustomer,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        String stringAfterCheck = "";
        if (!searchNameCustomer.isPresent()) {
            model.addAttribute("customerList", customerService.findAll(pageable));
        } else {
            stringAfterCheck = searchNameCustomer.get();
            model.addAttribute("customerList", customerService.searchCustomer(stringAfterCheck, pageable));
        }
        model.addAttribute("stringAfterCheck", stringAfterCheck);
        return "customer/list";
    }

    @GetMapping(value = "customer/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", new Customer());

        return "customer/create";
    }

    @PostMapping(value = "customer/create")
    public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new Customer().validate(customer,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        }else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("successMsg", "Create Customer: "+customer.getCustomerName() +" success!");
            return "redirect:/customer";
        }

    }

    @GetMapping(value = "customer/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model){
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping(value = "customer/edit")
    public String editCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new Customer().validate(customer,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/edit";
        }else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("successMsg", "Update Customer: "+customer.getCustomerName() +" success!");
            return "redirect:/customer";
        }
    }
    @GetMapping("customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }
    @PostMapping(value = "customer/delete")
    public String deleteCustomer(@RequestParam Long id, RedirectAttributes redirect){
        customerService.remove(id);
        redirect.addFlashAttribute("successMsg", "Delete Customer: "+" success!");
        return "redirect:/customer";
    }
    @GetMapping("customer/view/{id}")
    public String detailCustomer(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

    @GetMapping("customer/search")
    public ModelAndView searchCustomer(@RequestParam String keyword, @PageableDefault(value = 4) Pageable pageable){
            return new ModelAndView("customer/list", "customerList", customerService.searchCustomer(keyword, pageable));
    }
}

