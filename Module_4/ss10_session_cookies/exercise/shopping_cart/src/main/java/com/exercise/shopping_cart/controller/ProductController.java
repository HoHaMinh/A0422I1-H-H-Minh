package com.exercise.shopping_cart.controller;

import com.exercise.shopping_cart.model.Cart;
import com.exercise.shopping_cart.model.Product;
import com.exercise.shopping_cart.model.ProductOrder;
import com.exercise.shopping_cart.service.IProductOrderService;
import com.exercise.shopping_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart setUpCard() {
        return new Cart();
    }

    @Autowired
    private IProductService productService;
    @Autowired
    private IProductOrderService productOrderService;

    @GetMapping("")
    public ModelAndView showShop() {
        return new ModelAndView("shop", "products", productService.findAll());
    }
    @GetMapping("/show/{id}")
    public String showDescription (@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "description";
    }

    @GetMapping("/add/{id}/{action}")
    public String addToCart(@PathVariable("id") Long id, @ModelAttribute Cart cart, @PathVariable("action") String action) {
        Product product = productService.findById(id);
        if (product == null) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/shoppingCart";
        }
        if (action.equals("minus")) {
            cart.removeProduct(product);
            return "redirect:/shoppingCart";
        }
        cart.addProduct(product);
        return "redirect:/";
    }

    @PostMapping("/payment")
    public String doPayment(@ModelAttribute("cart") Cart cart, Model model) {
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            productOrderService.save(new ProductOrder(entry.getValue(),entry.getKey()));
        }
        return "payment";
    }
}
