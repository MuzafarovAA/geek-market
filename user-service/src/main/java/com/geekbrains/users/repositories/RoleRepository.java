package com.geekbrains.users.repositories;

import contract.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Transactional
    Role findOneByName(String theRoleName);
}
