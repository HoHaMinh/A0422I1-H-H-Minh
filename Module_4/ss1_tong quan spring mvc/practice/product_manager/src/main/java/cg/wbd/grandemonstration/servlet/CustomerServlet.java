package cg.wbd.grandemonstration.servlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerServlet {
    @GetMapping("/views")
    public String showList() {
        return "/list";
    }
}
