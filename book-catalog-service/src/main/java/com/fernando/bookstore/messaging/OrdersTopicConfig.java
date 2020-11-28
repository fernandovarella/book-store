package com.fernando.bookstore.messaging;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class OrdersTopicConfig {

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("orders.topic");
    }

    @Profile("dev")
    private static class ReceiverConfig {
 
        // @Bean
        // public OrderConfirmedReceiver receiver() {
        //     return new OrderConfirmedReceiver();
        // }

        @Bean
        public Queue autoDeleteQueue1() {
            return new AnonymousQueue();
        }

        @Bean
        public Binding bindingOrderConfirmed(TopicExchange topic, Queue autoDeleteQueue1) {
            return BindingBuilder.bind(autoDeleteQueue1)
                .to(topic)
                .with("order.confirmed");
        }
    }

    
}
