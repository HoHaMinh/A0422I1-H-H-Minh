package com.practice.login.controller;

import com.practice.login.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUpUser() {
        return new User();
    }

    @RequestMapping("")
    public String inded(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "home";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model,
                        @CookieValue(value = "setUser", defaultValue = "") String setUser,
                        HttpServletResponse response, HttpServletRequest request,
                        RedirectAttributes redirectAttributes) {
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            setUser = user.getEmail();
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie ck : cookies) {
                if (ck.getName().equals("setUser")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            redirectAttributes.addFlashAttribute("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookieValue", cookie);
            redirectAttributes.addFlashAttribute("message", "Login failed. Try again.");
        }
        return "redirect:";
    }
}
