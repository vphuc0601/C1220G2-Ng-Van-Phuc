package controller;

import model.EmailBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.EmailBoxService;
import service.impl.EmailBoxServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailBoxController {

    @Autowired
    public EmailBoxService emailBoxService;

    @GetMapping("/")
    public  ModelAndView getHomePage(Model model){
        List<String> listLanguage = this.emailBoxService.getLanguage();
        List<Integer> listPageSize = this.emailBoxService.getPageSize();
        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("listPageSize", listPageSize);
        return new ModelAndView("home","emailBox", new EmailBox());
    }
    @PostMapping("/create")
    public ModelAndView createEmailBox(Model model,@ModelAttribute EmailBox emailBox) {
        List<String> listLanguage = this.emailBoxService.getLanguage();
        List<Integer> listPageSize = this.emailBoxService.getPageSize();
        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("listPageSize", listPageSize);
        return new ModelAndView("view","emailBox",emailBox);
    }
//    @GetMapping("/update")
//    public String updateEmailBox(@ModelAttribute EmailBox emailBox, Model model){
//        model.addAttribute("emailBox",emailBox);
//        return "home";
//    }
}
