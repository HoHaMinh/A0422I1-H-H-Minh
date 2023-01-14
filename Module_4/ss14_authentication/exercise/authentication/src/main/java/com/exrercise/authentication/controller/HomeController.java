package com.exrercise.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("/member/home")
    public String user_home() {
        return "member";
    }
    @GetMapping("/admin/home")
    public String admin_home() {
        return "admin";
    }

    @GetMapping("/deny")
    public String deny() {
        return "403";
    }

    @RequestMapping(value = {"/login","/","/logout"})
    public String showLogin() {
        return "login";
    }
}
