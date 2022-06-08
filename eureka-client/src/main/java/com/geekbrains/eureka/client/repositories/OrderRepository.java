package com.geekbrains.eureka.client.repositories;

import com.geekbrains.eureka.client.entites.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
