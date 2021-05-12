package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String getMenu() {
        return "sandwich";
    }

    @PostMapping("save")
    public String save(@RequestParam(required = false, name = "spices") String[] spices, RedirectAttributes redirectAttributes) {
        String spice = "";
        if (spices != null) {
            for (String s : spices) {
                spice += s + ", ";
            }
        } else {
            spice = "null";
        }
        redirectAttributes.addFlashAttribute("spice", spice);
        return "redirect:/";
    }
}
