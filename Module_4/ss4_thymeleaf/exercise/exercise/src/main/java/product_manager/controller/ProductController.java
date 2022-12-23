package product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_manager.bean.Product;
import product_manager.service.IProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showHome() {
        ModelAndView modelAndView = new ModelAndView("home", "list", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/showAddForm")
    public String showUpdateForm(Model model) {
        List<Product> productList = productService.findAll();
        int numbersProduct = productList.size();
        if (numbersProduct >= 1) {
            model.addAttribute("id", productList.get(numbersProduct - 1).getProductId());
        } else {
            model.addAttribute("id", 0);
        }
        model.addAttribute("product", new Product());
        return "addForm";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        if (productService.add(product)) {
            redirectAttributes.addFlashAttribute("msg", "Add new product successfully");
        }
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        if (productService.remove(id - 1)) {
            redirectAttributes.addFlashAttribute("msg", "Remove product successfully");
        }
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("updateForm", "product", productService.findById(id - 1));
        return modelAndView;
    }

    @GetMapping("/update")
    public String update(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        if (productService.update(product)) {
            redirectAttributes.addFlashAttribute("msg", "Update successfully");
        }
        return "redirect:/";
    }

    @GetMapping("/searchName")
    public ModelAndView searchByName(@RequestParam("searching") String nameSearching) {
        ModelAndView modelAndView = new ModelAndView("home", "list", productService.findByName(nameSearching));
        return modelAndView;
    }
}
