package exercise.medical_declaration.controller;

import exercise.medical_declaration.bean.MedicalDeclaration;
import exercise.medical_declaration.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalService medicalService;

    @GetMapping("")
    public String showHome() {
        return "home";
    }

    @GetMapping("/detail")
    public ModelAndView showDetail() {
        ModelAndView modelAndView = new ModelAndView("detail", "detail", medicalService.show());
        return modelAndView;
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("medicalDeclaration", new MedicalDeclaration());
        List<Integer> yearOfBirth = new ArrayList<>();
        Date now = new Date();
        for (int i = 1900; i <= (now.getYear() + 1900); i++) {
            yearOfBirth.add(i);
        }
        model.addAttribute("yearOfBirth", yearOfBirth);
        model.addAttribute("gender", new boolean[]{true, false});
        model.addAttribute("nationality", new String[]{"Việt Nam", "Trung Quốc", "EU", "Khác"});
        model.addAttribute("transportVehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác"});
        model.addAttribute("cityOfAddress", new String[]{"Đà Nẵng", "Khác"});
        model.addAttribute("districtOfAddress", new String[]{"Thanh Khê", "Hải Châu", "Liên Chiểu", "Cẩm Lệ", "Ngũ Hành Sơn", "Sơn Trà", "Khác"});
        model.addAttribute("wardOfAddress", new String[]{"Hòa Khê", "An Khê", "Hòa Khánh", "Hải Châu", "Tam Thuận", "Khác"});
        model.addAttribute("symptom", new String[]{"Sốt", "Ho", "Khó thở", "Đau họng", "Nôn/buồn nôn", "Tiêu chảy", "Xuất huyết ngoài da", "Nổi ban ngoài da"});
        return "form";
    }

    @PostMapping("/addOrUpdate")
    public String addOrUpdate(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration,
                              RedirectAttributes redirectAttributes) {
        medicalService.addOrUpdate(medicalDeclaration);
        redirectAttributes.addFlashAttribute("msg", "Đã cập nhật tờ khai y tế");
        return "redirect:/";
    }
}
