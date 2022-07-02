package com.geekbrains.mail.controllers;

import contract.entities.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface MailController {

    @PostMapping("/sendEmail")
    void sendEmail(@RequestBody Order order);

}
