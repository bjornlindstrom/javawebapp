package com.bjorn.controller;

import com.bjorn.message.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HomeController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;

    @RequestMapping("/test")
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/send")
    public void send(){
        rabbitTemplate.convertAndSend("/topic/message", "Hello from RabbitMQ!");
    }

    @RequestMapping("/receive")
    public String receive(){
        return String.valueOf(receiver.getLatch().getCount());
    }

//    @RequestMapping("/send2")
//    public void greet(String greeting) {
//        System.out.println("send2");
//        String text = "[" + System.currentTimeMillis() + "]:" + greeting;
//        this.rabbitTemplate.convertAndSend("/topic/message", text);
//    }
}