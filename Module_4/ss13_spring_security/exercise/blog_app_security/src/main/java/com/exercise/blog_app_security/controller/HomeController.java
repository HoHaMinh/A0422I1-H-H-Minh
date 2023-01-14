package com.exercise.blog_app_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/deny")
    public String deny() {
        return "deny";
    }

    @RequestMapping (value = {"/","/login","/home","/logout"})
    public String showLogin() {
        return "login";
    }
}
