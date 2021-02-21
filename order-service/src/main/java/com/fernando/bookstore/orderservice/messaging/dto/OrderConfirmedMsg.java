package com.fernando.bookstore.orderservice.messaging.dto;

import com.fernando.bookstore.orderservice.data.model.OrderStatusEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Builder
@Value
public class OrderConfirmedMsg {
    
    private String orderId;

    private OrderStatusEnum status;

}
