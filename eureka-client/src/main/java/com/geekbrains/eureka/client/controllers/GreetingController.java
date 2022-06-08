package com.geekbrains.eureka.client.controllers;

import com.geekbrains.eureka.client.entites.Product;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface GreetingController {
    @RequestMapping("/get-products")
    List<Product> getProduct();
}
