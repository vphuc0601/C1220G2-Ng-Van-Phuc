package com.form_validate.controller;

import com.form_validate.model.User;
import com.form_validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping({"","/"})
    public ModelAndView showCreateUser() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("create")
    public ModelAndView checkNameValidattion(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,Model model){
        new User().validate(user, bindingResult);
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView=new ModelAndView("create");
            return modelAndView;
        }
        userService.save(user);
        ModelAndView modelAndView=new ModelAndView();
        return modelAndView;
    }
}
