package com.geekbrains.users.repositories;


import contract.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Transactional
    User findOneByUserName(String userName);

    @Transactional
    List<User> findAll();
}
