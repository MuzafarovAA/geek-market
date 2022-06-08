package com.geekbrains.eureka.feign.client;

import com.geekbrains.eureka.client.entites.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("geek-market-winter-eureka-client")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();

    @RequestMapping("/greeting1")
    String greeting1();

    @RequestMapping("/greeting-example")
    String greetingExample();

    @RequestMapping("/get-products")
    List<Product> getProduct();
}
