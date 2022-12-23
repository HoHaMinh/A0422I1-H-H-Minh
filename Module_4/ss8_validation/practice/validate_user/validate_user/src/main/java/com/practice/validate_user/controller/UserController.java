package com.practice.validate_user.controller;

import com.practice.validate_user.model.User;
import com.practice.validate_user.validate.UserValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserValidate userValidate;
    @GetMapping("")
    public ModelAndView showForm () {
        return new ModelAndView("form","user", new User("",0,""));
    }
    @PostMapping("/add")
    public String add (@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidate.validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "result";
    }
}
