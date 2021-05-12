package com.form_input.controller;

import com.form_input.model.User;
import com.form_input.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserService userService;
//    @GetMapping({"","/"})
//    public ModelAndView showUser(User user){
//       return new ModelAndView("list", "listUser", this.userService.findAll());
//    }
    @GetMapping({"","/"})
    public  ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("result");
            return modelAndView;
        }
    }
}
