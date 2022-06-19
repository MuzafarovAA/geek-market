package com.geekbrains.geekmarketwinter.controllers;

import com.geekbrains.geekmarketwinter.services.ShoppingCartService;
import com.geekbrains.geekmarketwinter.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {
    private ShoppingCartService shoppingCartService;

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String cartPage(Model model, HttpSession httpSession) {
        ShoppingCart cart = shoppingCartService.getCurrentCart(httpSession);
        model.addAttribute("cart", cart);
        return "cart-page";
    }


    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id, HttpServletRequest httpServletRequest) {
        shoppingCartService.addToCart(httpServletRequest.getSession(), id);
        String referrer = httpServletRequest.getHeader("referer");

        return "redirect:" + referrer;
    }

    @GetMapping("/remove/{id}")
    public String removeProductFromCart(Model model, @PathVariable("id") Long id, HttpServletRequest httpServletRequest) {
        shoppingCartService.removeFromCart(httpServletRequest.getSession(), id);
        String referrer = httpServletRequest.getHeader("referer");

        return "redirect:" + referrer;
    }

    @GetMapping("/reset")
    public String resetCart(Model model, HttpServletRequest httpServletRequest) {
        shoppingCartService.resetCart(httpServletRequest.getSession());
        String referrer = httpServletRequest.getHeader("referer");

        return "redirect:" + referrer;
    }
}
