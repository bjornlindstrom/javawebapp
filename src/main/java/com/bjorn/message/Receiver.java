package com.bjorn.message;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Björn on 2015-12-06.
 */
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(100);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
