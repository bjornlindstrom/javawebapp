package com.bjorn.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Björn on 2015-12-07.
 */
@Service
public class ScheduleTask {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);


    @Autowired
    private SimpMessagingTemplate template;

    // this will send a message to an endpoint on which a client can subscribe
//    @Scheduled(fixedRate = 5000)
//    public void trigger() {
//        logger.debug("send to queue");
//        this.template.convertAndSend("/topic/message", "Date: " + new Date());
//    }


}