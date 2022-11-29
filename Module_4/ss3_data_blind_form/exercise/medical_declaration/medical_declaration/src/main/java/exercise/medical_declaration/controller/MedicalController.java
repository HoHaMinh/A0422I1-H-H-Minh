package exercise.medical_declaration.controller;

import exercise.medical_declaration.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MedicalController {
    @Autowired
    IMedicalService medicalService;

    @GetMapping("")
    public String showHome() {
        return "home";
    }

    @GetMapping("/detail")
    public ModelAndView showDetail() {
        ModelAndView modelAndView = new ModelAndView("detail", "detail", medicalService.show());
        return modelAndView;
    }
    @GetMapping ("/showForm")
    public String showForm (Model model) {
        model.addAttribute("medicalDeclaration",medicalService.show());
        List<Integer> yearOfBirth = new ArrayList<>();
        Date now = new Date();
        for (int i=1900; i<=now.getYear(); i++) {
            yearOfBirth.add(i);
        }
        model.addAttribute("yearOfBirth", yearOfBirth);
        model.addAttribute("gender", new boolean[] {true,false});
        model.addAttribute("nationality", new String[] {"Việt Nam", "Trung Quốc", "EU", "Khác"});
        model.addAttribute("transportVehicle", new String[] {"Tàu bay", "Tàu thuyền", "Ô tô", "Khác"});
        model.addAttribute("cityOfAddress", new String[] {"Đà Nẵng", "Hà Nội", "Hồ Chí Minh", "Khác"});
        return "form";
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdate () {
        return "redirect:/form";
    }
}
