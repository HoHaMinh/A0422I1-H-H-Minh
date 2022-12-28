package com.exercise.shopping_cart.controller;

import com.exercise.shopping_cart.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {
    @ModelAttribute("cart")
    public Cart setUpCart () {
        return new Cart();
    }

    @GetMapping("/shoppingCart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        return new ModelAndView("cart", "cart",cart);
    }
}
