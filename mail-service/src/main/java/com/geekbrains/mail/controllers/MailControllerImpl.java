package com.geekbrains.mail.controllers;

import com.geekbrains.mail.services.MailService;
import contract.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailControllerImpl implements MailController{
    private MailService mailService;

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void sendEmail(Order order) {
        mailService.sendMail(order);
    }
}
