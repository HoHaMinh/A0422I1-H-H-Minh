package com.exercise.case_study.controller;

import com.exercise.case_study.model.customer.Customer;
import com.exercise.case_study.model.customer.CustomerType;
import com.exercise.case_study.service.customer.ICustomerService;
import com.exercise.case_study.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/employee/customer")
    private String showList(Model model, @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        Page<Customer> customers = customerService.showAllWithPaging(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("customers", customers);
        int totalPages = customers.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "customer/list";
    }

    @GetMapping("/employee/customer/showAddForm")
    private ModelAndView showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return new ModelAndView("customer/addForm","customerTypeList", customerTypeService.showAll());
    }

    @PostMapping("/employee/customer/add")
    public String add(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Add customer successfully");
        return "redirect:/employee/customer";
    }

    @GetMapping("/employee/customer/showEditForm/{id}")
    private ModelAndView showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customerTypeList", customerTypeService.showAll());
        Customer customer = customerService.findById(id);
        return new ModelAndView("customer/editForm","customer", customer);
    }

    @PostMapping("/employee/customer/edit")
    public String edit(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit customer successfully");
        return "redirect:/employee/customer";
    }

    @GetMapping("/employee/customer/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Delete customer successfully");
        return "redirect:/employee/customer";
    }
}
