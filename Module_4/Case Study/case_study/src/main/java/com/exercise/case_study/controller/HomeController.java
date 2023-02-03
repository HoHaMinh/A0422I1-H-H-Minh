package com.exercise.case_study.controller;

import com.exercise.case_study.service.contract.IContractDetailService;
import com.exercise.case_study.service.contract.IContractService;
import com.exercise.case_study.service.employee.IEmployeeService;
import com.exercise.case_study.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IServiceService service;

    @GetMapping("/employee/home")
    public ModelAndView showHome () {
        return new ModelAndView("home");
    }
}
