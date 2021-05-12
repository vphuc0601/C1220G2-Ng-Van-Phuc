package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CaculatorService;

@Controller
public class CaculatorController {

    @Autowired
    private CaculatorService caculatorService;
    @GetMapping("/")
    public String showCaculator(){
        return "caculator";
    }
    @PostMapping("/caculator")
        public String caculator(@RequestParam double number1, @RequestParam double number2, String operator, Model model){

            model.addAttribute("number1", number1);
            model.addAttribute("number2", number2);
            model.addAttribute("operator", operator);
        try {
            model.addAttribute("result",caculatorService.caculator(number1,number2,operator));
        } catch (Exception e) {
            model.addAttribute("result", e.getMessage());
        }
        return "/caculator";
        }
}


