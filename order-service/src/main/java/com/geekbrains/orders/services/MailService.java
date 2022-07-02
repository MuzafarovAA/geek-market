package com.geekbrains.orders.services;

import contract.entities.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mail-service-client", contextId = "mail-service")
public interface MailService {

    @PostMapping("/sendEmail")
    void sendEmail(@RequestBody Order order);

}
