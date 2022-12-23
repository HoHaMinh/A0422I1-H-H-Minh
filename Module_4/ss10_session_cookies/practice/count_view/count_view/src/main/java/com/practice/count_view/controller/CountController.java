package com.practice.count_view.controller;

import com.practice.count_view.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CountController {
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter(0);
    }

    @GetMapping("")
    public String count(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "/home";
    }
}
