package com.bjorn.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by Björn on 2015-12-06.
 */
@Controller
public class GreetingController {


    @MessageMapping("/greeting")
    @SendTo("/topic/message")
    public Greeting greeting(HelloMessage message) throws Exception {
        System.out.println("in greeting");
//        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
