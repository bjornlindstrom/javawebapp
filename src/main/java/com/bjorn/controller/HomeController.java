package com.bjorn.controller;

import com.bjorn.message.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;

    @RequestMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/send")
    public void send(){
        rabbitTemplate.convertAndSend("test", "Hello from RabbitMQ!");
    }

    @RequestMapping("/receive")
    public String receive(){
        return String.valueOf(receiver.getLatch().getCount());
    }
}