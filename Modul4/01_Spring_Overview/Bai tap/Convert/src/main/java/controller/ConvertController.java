package controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController{
        @GetMapping
        public String home(){
            return "convert";
        }
        @PostMapping("/convert")
        public String result(@RequestParam String unit, Double result,Double number, Model model){
            switch (unit){
                case "VND":result=number/23000;
                    model.addAttribute("result", result);
                    model.addAttribute("unit", unit);
                    return "result";
                case "USD":
                    result =number*23000;
                    model.addAttribute("result", result);
                    model.addAttribute("unit", unit);
                    return "result";
                default:
                    return "convert";


            }
//        if(unit.equals("VND")){
//            result=number/23000;
//            model.addAttribute("result", result);
//            model.addAttribute("unit", unit);
//            return "result";
//
//        }else(unit.equals("USD")) {
//            result =number*23000;
//            model.addAttribute("result", result);
//            model.addAttribute("unit", unit);
//            return "result";
//
//        }
        }
}
