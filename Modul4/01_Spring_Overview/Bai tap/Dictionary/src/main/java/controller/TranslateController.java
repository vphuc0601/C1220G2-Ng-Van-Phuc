package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.TreeMap;

@Controller
public class TranslateController {
    @GetMapping
    public String home(){
        return "home";
    }
    @PostMapping("/translate")
    String translate(@RequestParam String word, Model model){
//        model.addAttribute("word", word);
        TreeMap<String ,String > treeMap=new TreeMap<String, String>();
        treeMap.put("1","one");
        treeMap.put("2", "two");
        treeMap.put("3", "three");
        treeMap.put("4", "four");
        if(treeMap.containsKey(word)){
            model.addAttribute("value", treeMap.get(word));
        }
        return "translate";
    }
}
