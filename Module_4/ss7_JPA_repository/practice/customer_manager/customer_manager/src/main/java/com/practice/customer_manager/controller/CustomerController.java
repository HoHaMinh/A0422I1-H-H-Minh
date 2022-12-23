package com.practice.customer_manager.controller;

import com.practice.customer_manager.model.Customer;
import com.practice.customer_manager.model.Province;
import com.practice.customer_manager.service.ICustomerService;
import com.practice.customer_manager.service.IProvinceService;
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
    IProvinceService provinceService;
    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showListProvince() {
        return new ModelAndView("list","list",provinceService.findAll());
    }

    @GetMapping("/showCreateForm")
    public ModelAndView showCreateForm() {
        return new ModelAndView("createForm","province",new Province());
    }

    @PostMapping("/create")
    public String saveProvince(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "New province created successfully");
        return "redirect:";
    }

    @GetMapping("/showEditForm/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Integer id) {
            return new ModelAndView("editForm","province",provinceService.findById(id));
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("province") Province province, RedirectAttributes redirectAttributes) {
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("message", "Province updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable ("id") Integer id) {
        provinceService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/showListCustomer")
    public ModelAndView showListCustomer(Model model, @RequestParam("page")Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer>size,
                                         @RequestParam("search") Optional<String> searchingInput){
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        String input = searchingInput.orElse(null);
        Page<Customer> customerPage;
        if (searchingInput.isPresent()) {
            customerPage = customerService.findAllByFirstName(input,PageRequest.of(currentPage-1,pageSize));
        } else {
            customerPage = customerService.findAllWithPaging(PageRequest.of(currentPage-1,pageSize));
        }
        Integer totalPages = customerPage.getTotalPages();
        if(totalPages>1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers",pageNumbers);
        }
        return new ModelAndView("customer/list","list",customerPage);
    }

    @GetMapping("/showCreateCustomerForm")
    public ModelAndView showCreateCustomerForm(Model model) {
        model.addAttribute("province", provinceService.findAll());
        return new ModelAndView("customer/createForm","customer",new Customer("",""));
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/showListCustomer";
    }

    @GetMapping("/showEditCustomerForm/{id}")
    public ModelAndView showEditCustomerForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("province", provinceService.findAll());
        return new ModelAndView("customer/editCustomerForm","customer",customerService.findById(id));
    }

    @PostMapping("/editCustomer")
    public String editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/showListCustomer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer (@PathVariable ("id") Integer id) {
        customerService.remove(id);
        return "redirect:/showListCustomer";
    }
}
