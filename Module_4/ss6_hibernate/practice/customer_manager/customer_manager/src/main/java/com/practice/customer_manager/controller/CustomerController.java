package com.practice.customer_manager.controller;

import com.practice.customer_manager.model.Customer;
import com.practice.customer_manager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("list","list",customerService.showAll());
    }

    @GetMapping("/showCreateForm")
    public ModelAndView showCreateForm() {
        return new ModelAndView("createForm","customer", new Customer("",""));
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer) {
        customerService.insert(customer.getFirstName(),customer.getLastName());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteById (@PathVariable("id") Integer id) {
        customerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/showEditForm/{id}")
    public ModelAndView showEditForm (@PathVariable("id")Integer id) {
        return new ModelAndView("editForm","customer",customerService.showById(id));
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
}
