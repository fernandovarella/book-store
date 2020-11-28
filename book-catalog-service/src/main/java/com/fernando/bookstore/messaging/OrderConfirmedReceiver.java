package com.fernando.bookstore.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConfirmedReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiveOrderConfirmed(String message) throws InterruptedException {
        receive(message);
    }


    private void receive(String message) {
        System.out.println("====================================== "
            + "RECEIVING MESSAGE " + message);
    }
    
}
