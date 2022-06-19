package com.geekbrains.users.controllers;

import contract.entities.SystemUser;
import contract.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserController {

    @GetMapping("/getUserByUsername")
    User findByUserName(@RequestParam("username") String username);

    @GetMapping("/getAllUsers")
    List<User> findAll();

    @GetMapping("/save")
    boolean save(SystemUser systemUser);

    @GetMapping("/loadUserByUsername")
    UserDetails loadUserByUsername(@RequestParam("username") String username);

}
