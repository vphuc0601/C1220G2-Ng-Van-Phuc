package com.codegym.controller;

import com.codegym.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes(value = "userLogin")
public class LoginController {

    @GetMapping(value = "/login")
    public String goLogin(Model model,
                          @CookieValue (value = "usernameC", defaultValue = "") String username,
                          @CookieValue (value = "passwordC", defaultValue = "") String password) {
        model.addAttribute("userLogin", new User(username, password));
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute(value = "userLogin") User user, HttpServletResponse response) {
        Cookie cookieUsername = new Cookie("usernameC", user.getUsername());
        Cookie cookiePassword = new Cookie("passwordC", user.getPassword());
        cookieUsername.setMaxAge(30);
        cookiePassword.setMaxAge(30);

        response.addCookie(cookieUsername);
        response.addCookie(cookiePassword);

        return "redirect:/";
    }
}
