package com.example.phone_manager.controller;

import com.example.phone_manager.entity.Phone;
import com.example.phone_manager.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;
    @GetMapping({"","/"})
    public ModelAndView getListPhone(@PageableDefault(value = 4) Pageable pageable){
        return new ModelAndView("list", "productList",phoneService.findAll(pageable));
    }
    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("phone", new Phone());
        return "/create";
    }

    @PostMapping(value = "/create")
    public String createStudent(@ModelAttribute Phone phone, RedirectAttributes redirectAttributes) {
        phoneService.save(phone);
        redirectAttributes.addFlashAttribute("successMsg", "Create phone: "+phone.getName() +" success!");
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model){
        System.out.println(id);
        model.addAttribute("product", phoneService.findById(id));
        return "/edit";
    }

    @PostMapping(value = "/edit")
    public String editStudent(@ModelAttribute Phone phone, RedirectAttributes redirectAttributes){
        phoneService.save(phone);
        redirectAttributes.addFlashAttribute("successMsg", "Update student: "+phone.getName() +" success!");
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView searchByText(@RequestParam String inputSearch, @PageableDefault(value = 10)Pageable pageable){
        return new ModelAndView("list", "productList", phoneService.findByInputText(inputSearch, pageable));
    }
}
