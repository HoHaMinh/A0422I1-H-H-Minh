package practice.customer_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import practice.customer_manager.bean.Customer;
import practice.customer_manager.service.CustomerServiceFactory;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerServiceFactory customerService;

    @GetMapping("/home")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

}