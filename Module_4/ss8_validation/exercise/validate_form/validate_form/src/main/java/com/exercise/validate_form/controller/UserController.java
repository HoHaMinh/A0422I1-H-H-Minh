package com.exercise.validate_form.controller;

import com.exercise.validate_form.model.User;
import com.exercise.validate_form.service.IUserService;
import com.exercise.validate_form.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    UserValidate userValidate;

    @GetMapping("")
    public ModelAndView showList () {
        return new ModelAndView("list","list",userService.showAll());
    }

    @GetMapping("/showCreateForm")
    public String showCreateForm (Model model) {
        model.addAttribute("user", new User());
        return "createForm";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        userValidate.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "createForm";
        }
        userService.save(user);
        return "redirect:/";
    }
}
