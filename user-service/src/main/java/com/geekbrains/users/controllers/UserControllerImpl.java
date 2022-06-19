package com.geekbrains.users.controllers;

import com.geekbrains.users.services.UserService;
import contract.entities.SystemUser;
import contract.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class UserControllerImpl implements UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User findByUserName(String username) {
        return userService.findByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public boolean save(SystemUser systemUser) {
        return userService.save(systemUser);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) {
        return userService.loadUserByUsername(userName);
    }
}
