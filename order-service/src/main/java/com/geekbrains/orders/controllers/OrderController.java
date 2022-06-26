package com.geekbrains.orders.controllers;

import contract.entities.Order;
import contract.entities.ShoppingCart;
import contract.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface OrderController {
    @PostMapping("/makeOrder")
    Order makeOrder(@RequestBody ShoppingCart cart, @RequestParam("username") String user);

    @GetMapping("/getAllOrders")
    List<Order> getAllOrders();

    @GetMapping("/findById")
    Order findById(@RequestParam("id") Long id);

    @PostMapping("/saveOrder")
    Order saveOrder(@RequestBody Order order);

    @PutMapping("/changeOrderStatus")
    Order changeOrderStatus(@RequestBody Order order, @RequestParam("id") Long statusId);
}

