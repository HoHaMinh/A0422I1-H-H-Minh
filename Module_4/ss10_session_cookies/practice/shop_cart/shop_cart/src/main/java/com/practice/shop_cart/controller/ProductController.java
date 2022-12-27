package com.practice.shop_cart.controller;

import com.practice.shop_cart.model.Cart;
import com.practice.shop_cart.model.Product;
import com.practice.shop_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart setUpCard () {
        return new Cart();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ModelAndView showShop() {
        return new ModelAndView("shop","products", productService.findAll());
    }

    @GetMapping("/add/{id}/{action}")
    public String addToCart(@PathVariable ("id") Long id, @ModelAttribute Cart cart, @PathVariable("action") String action) {
        Product product = productService.findById(id);
        if (product==null) {
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
}
