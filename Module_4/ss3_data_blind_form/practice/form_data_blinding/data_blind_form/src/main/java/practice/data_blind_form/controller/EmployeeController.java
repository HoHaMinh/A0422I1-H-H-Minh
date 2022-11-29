package practice.data_blind_form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import practice.data_blind_form.bean.Employee;

import javax.servlet.http.*;

@Controller
public class EmployeeController extends HttpServlet {
    @GetMapping("/create")
    public String showForm (Model model) {
        model.addAttribute("employee",new Employee());
        return "create";
    }

    @PostMapping("/add")
    public String submit (@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "info";
    }
}