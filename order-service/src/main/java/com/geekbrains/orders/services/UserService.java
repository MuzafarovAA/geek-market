package com.geekbrains.orders.services;

import contract.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service-client", contextId = "user-service")
public interface UserService {
    @GetMapping("/getUserByUsername")
    User findByUserName(@RequestParam("username") String username);
}
