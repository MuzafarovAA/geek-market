package com.geekbrains.users.services;

import contract.entities.SystemUser;
import contract.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);

    List<User> findAll();

    boolean save(SystemUser systemUser);

    UserDetails loadUserByUsername(String userName);

}
