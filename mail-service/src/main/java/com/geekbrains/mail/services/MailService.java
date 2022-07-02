package com.geekbrains.mail.services;

import contract.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Order order) {
        String orderStatus = order.getStatus().getTitle();
        String subject = "Ваш заказ из Интернет-магазина " + orderStatus;
        String email = order.getUser().getEmail();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(order.getUser().getFirstName())
                .append(" ")
                .append(order.getUser().getLastName())
                .append(", Ваш заказ на общую сумму ")
                .append(order.getPrice())
                .append(" ")
                .append(orderStatus)
                .append("\nБлагодарим за выбор нашей площадки");
        String text = stringBuilder.toString();

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom(username);
            helper.setSubject(subject);
            helper.setTo(email);
            helper.setText(text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);

    }

}
