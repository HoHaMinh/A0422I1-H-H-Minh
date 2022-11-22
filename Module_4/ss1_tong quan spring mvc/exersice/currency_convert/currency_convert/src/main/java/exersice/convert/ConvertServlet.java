package exersice.convert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@Controller
public class ConvertServlet {
    @GetMapping("/home")
    public String goHome() {
        return "home";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("usd") double usd, Model model) {
        double vnd;
        vnd = usd * 24857;
        model.addAttribute("vnd",vnd);
        return "home";
    }
}