package com.fernando.bookstore.orderservice.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitProducerConfig {

    //System.out.println("Sample usage: java -jar target/rabbit-learn-0.0.1-SNAPSHOT.jar --spring.profiles.active=book-store-producers,order-confirmed-sender");
    //System.out.println("Sample usage: java -jar target/rabbit-learn-0.0.1-SNAPSHOT.jar --spring.profiles.active=topic,receiver");

    @Bean
    public TopicExchange ordersTopic() {
        return new TopicExchange("orders.topic");
    }

    @Bean
    public OrdersMessagesSender ordersMessagesSender() {
        return new OrdersMessagesSender();
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
    
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}