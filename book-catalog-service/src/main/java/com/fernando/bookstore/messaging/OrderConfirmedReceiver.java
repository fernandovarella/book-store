package com.fernando.bookstore.messaging;

import com.fernando.bookstore.messaging.dto.OrderConfirmedMsg;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConfirmedReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiveOrderConfirmed(OrderConfirmedMsg message) throws InterruptedException {
        receive(message);
    }


    private void receive(OrderConfirmedMsg orderConfirmedMsg) {
        System.out.println("====================================== "
            + "RECEIVING MESSAGE " + orderConfirmedMsg.toString());
    }
    
}
