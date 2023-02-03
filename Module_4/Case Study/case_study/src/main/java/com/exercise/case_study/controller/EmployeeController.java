package com.exercise.case_study.controller;

import com.exercise.case_study.model.employee.Employee;
import com.exercise.case_study.model.employee.UserId;
import com.exercise.case_study.repository.employee.IUserIdRepository;
import com.exercise.case_study.service.employee.IDivisionService;
import com.exercise.case_study.service.employee.IEducationDegreeService;
import com.exercise.case_study.service.employee.IEmployeeService;
import com.exercise.case_study.service.employee.IPositionService;
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
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    IUserIdRepository userIdRepository;

    @GetMapping("/manager/employee")
    private String showList(Model model, @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        Page<Employee> employees = employeeService.showAllWithPaging(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("employees", employees);
        int totalPages = employees.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "employee/list";
    }

    @GetMapping("/manager/employee/showAddAccountForm")
    private ModelAndView showAddAccountForm() {
        return new ModelAndView("employee/addAccountForm","account", new UserId());
    }

    @PostMapping("/manager/employee/showAddEmployeeForm")
    private ModelAndView showAddForm(@ModelAttribute("account") UserId userId, Model model) {
        model.addAttribute("positionList", positionService.showAll());
        model.addAttribute("educationDegreeList", educationDegreeService.showAll());
        model.addAttribute("divisionList", divisionService.showAll());
        userIdRepository.save(userId);
        model.addAttribute("accountUser", userId);
        return new ModelAndView("employee/addEmployeeForm","employee", new Employee());
    }

    @PostMapping("/manager/employee/add")
    public String add(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "Add employee successfully");
        return "redirect:/manager/employee";
    }

    @GetMapping("/manager/employee/showEditForm/{id}")
    private ModelAndView showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("positionList", positionService.showAll());
        model.addAttribute("educationDegreeList", educationDegreeService.showAll());
        model.addAttribute("divisionList", divisionService.showAll());
        Employee employee = employeeService.findById(id);
        return new ModelAndView("employee/editForm","employee", employee);
    }

    @PostMapping("/manager/employee/edit")
    public String edit(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "Edit employee successfully");
        return "redirect:/manager/employee";
    }

    @GetMapping("/manager/employee/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Delete employee successfully");
        return "redirect:/manager/employee";
    }
}
