package exercise.caculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
@GetMapping("")
    public String goHome () {
    return "home";
}
@GetMapping("/caculate")
    public String caculate (@RequestParam(value = "number1", defaultValue = "") String num1,
                            @RequestParam (value = "number2", defaultValue = "") String num2,
                            @RequestParam ("caculate") String caculator,
                            Model model) {
    double number1 = Double.parseDouble(num1);
    double number2 = Double.parseDouble(num2);
    double result=0;
    String mess="";
    switch (caculator) {
        case "addition":
            result = number1 + number2;
            break;
        case "subtraction":
            result = number1 - number2;
            break;
        case "multiplication":
            result = number1*number2;
            break;
        case "division":
            if (number2==0) {
               mess = "Can not divide by 0";
            }
            result = number1/number2;
    }
    model.addAttribute("result",result);
    model.addAttribute("mess",mess);
    return "home";
}
}