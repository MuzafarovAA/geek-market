package com.geekbrains.users.controllers;

import contract.entities.SystemUser;
import contract.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserController {

    @GetMapping("/getUserByUsername")
    User findByUserName(@RequestParam("username") String username);

    @GetMapping("/getAllUsers")
    List<User> findAll();

    @GetMapping("/save")
    boolean save(SystemUser systemUser);

}
