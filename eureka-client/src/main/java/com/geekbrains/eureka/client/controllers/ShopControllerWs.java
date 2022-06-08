package com.geekbrains.eureka.client.controllers;

import com.geekbrains.eureka.client.entites.Greeting;
import com.geekbrains.eureka.client.entites.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ShopControllerWs {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting(message.getName() + " добавлен в корзину!");
    }
}
