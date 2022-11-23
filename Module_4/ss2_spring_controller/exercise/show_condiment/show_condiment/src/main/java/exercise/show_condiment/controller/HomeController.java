package exercise.show_condiment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class HomeController{
    @GetMapping("")
    public String goHome (){
        return "home";
    }
    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "No choice") String[] condiment, Model model) {
        model.addAttribute("condiments",condiment);
            return "home";
    }
}