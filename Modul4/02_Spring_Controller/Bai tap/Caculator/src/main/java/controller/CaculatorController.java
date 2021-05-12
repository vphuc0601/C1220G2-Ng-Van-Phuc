package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CaculatorService;
import service.impl.CaculatorServiceImpl;


@Controller
public class CaculatorController {
    @Autowired
    private CaculatorServiceImpl caculatorService;
//    @Autowired
//    CaculatorService caculatorService;
//
    @GetMapping
    public String showCaculator(){
        return "caculator";
    }
    @PostMapping ("/caculator")
    public String caculator(@RequestParam double number1, @RequestParam double number2, String operator, Model model){
        double result=calculatorService.caculator(number1,number2,operator);
        model.addAttribute("result",result);
        return "/caculator";
    }
}
