package exercise.email_config_save.controller;

import exercise.email_config_save.bean.EmailConfig;
import exercise.email_config_save.service.IEmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
@Autowired
    IEmailConfigService emailConfigService;
@GetMapping("")
    public ModelAndView showHome () {
    ModelAndView modelAndView = new ModelAndView("home","emailConfig", emailConfigService.showAll());
    return modelAndView;
}
@GetMapping("/showUpdate")
    public String showUpdateForm (Model model) {
    model.addAttribute("emailConfig",new EmailConfig("",0,false,""));
    model.addAttribute("language",new String[] {"English", "Vietnamese", "Japanese", "Chinese"});
    model.addAttribute("pageSize", new Integer[] {5,10,15,25,50,100});
//    model.addAttribute("isAllowSpam",new boolean[]{true,false});
    return "updateForm";
}

@GetMapping("/update")
    public String update (@ModelAttribute("emailConfig") EmailConfig emailConfig, RedirectAttributes redirectAttributes) {
    emailConfigService.update(emailConfig);
    redirectAttributes.addFlashAttribute("msg","Update successfully");
    return "redirect:/";
}

}