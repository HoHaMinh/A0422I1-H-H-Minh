package com.exercise.case_study.controller;

import com.exercise.case_study.model.contract.Contract;
import com.exercise.case_study.model.service.Service;
import com.exercise.case_study.service.contract.IContractService;
import com.exercise.case_study.service.customer.ICustomerService;
import com.exercise.case_study.service.employee.IEmployeeService;
import com.exercise.case_study.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @GetMapping("/employee/service")
    private String showList(Model model, @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        model.addAttribute("currentPage", currentPage);
        Page<Service> services = serviceService.showAllWithPaging(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("services", services);
        int totalPages = services.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "service/list";
    }

    @GetMapping("/employee/contract/showAddForm")
    private ModelAndView showAddForm(Model model) {
        model.addAttribute("employees", employeeService.showAll());
        model.addAttribute("customers", customerService.showAll());
        model.addAttribute("services", serviceService.showAll());
        return new ModelAndView("contract/addForm","contract", new Contract());
    }

}
