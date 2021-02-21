package com.fernando.bookstore.orderservice.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernando.bookstore.orderservice.messaging.dto.OrderConfirmedMsg;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersMessagesSender {

    private static final String KEY_ORDER_CONFIRMED = "order.confirmed";

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange ordersTopic;

    public void sendOrderConfirmed(OrderConfirmedMsg orderConfirmed) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            template.convertAndSend(ordersTopic.getName(), KEY_ORDER_CONFIRMED, orderConfirmed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
