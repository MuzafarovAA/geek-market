package com.geekbrains.eureka.client.controllers;

import com.geekbrains.eureka.client.entites.Product;
import com.geekbrains.eureka.client.services.ProductService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GreetingControllerImpl implements GreetingController {

    private EurekaClient eurekaClient;
    private ProductService productService;

    @Autowired
    @Lazy
    public void setEurekaClient(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Value("${spring.application.name}")
    private String appName;


    @Override
    public List<Product> getProduct() {
        return productService.getAllProducts();
    }
}
