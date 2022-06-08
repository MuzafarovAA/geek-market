package com.geekbrains.eureka.client.services;

import com.geekbrains.eureka.client.entites.SystemUser;
import com.geekbrains.eureka.client.entites.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);
    boolean save(SystemUser systemUser);
}
