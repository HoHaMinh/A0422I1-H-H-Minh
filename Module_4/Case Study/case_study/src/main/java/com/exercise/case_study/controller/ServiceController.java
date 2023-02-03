package com.exercise.case_study.controller;

import com.exercise.case_study.model.service.Service;
import com.exercise.case_study.service.service.IRentTypeService;
import com.exercise.case_study.service.service.IServiceService;
import com.exercise.case_study.service.service.IServiceTypeService;
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
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @GetMapping("/employee/service")
    private String showList(Model model, @RequestParam("page") Optional<Integer> page,
                            @RequestParam("size") Optional<Integer> size) {
        Integer currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);
        Page<Service> services = serviceService.showAllWithPaging(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("services", services);
        int totalPages = services.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "service/list";
    }

    @GetMapping("/employee/service/showAddForm")
    private ModelAndView showAddForm(Model model) {
        model.addAttribute("rentTypeList", rentTypeService.showAll());
        model.addAttribute("serviceTypeList", serviceTypeService.showAll());
        return new ModelAndView("service/addForm","service", new Service());
    }

    @PostMapping("/employee/service/add")
    public String add(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes) {
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("mess", "Add service successfully");
        return "redirect:/employee/service";
    }
}
