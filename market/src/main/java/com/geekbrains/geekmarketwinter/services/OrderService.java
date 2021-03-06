package com.geekbrains.geekmarketwinter.services;

import contract.entities.Order;
import contract.entities.ShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-service-client", contextId = "order-service")
public interface OrderService {

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
