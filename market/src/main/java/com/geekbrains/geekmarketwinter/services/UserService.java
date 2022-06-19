package com.geekbrains.geekmarketwinter.services;

import contract.entities.SystemUser;
import contract.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service-client", contextId = "user-service")
public interface UserService extends UserDetailsService {

    @GetMapping("/getUserByUsername")
    User findByUserName(@RequestParam("username") String username);

    @GetMapping("/getAllUsers")
    List<User> findAll();

    @GetMapping("/save")
    boolean save(SystemUser systemUser);

    @GetMapping("/loadUserByUsername")
    UserDetails loadUserByUsername(@RequestParam("username") String userName);

}
