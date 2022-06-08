package com.geekbrains.eureka.client.repositories;

import com.geekbrains.eureka.client.entites.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
