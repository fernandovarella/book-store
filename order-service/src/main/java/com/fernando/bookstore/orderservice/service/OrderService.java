package com.fernando.bookstore.orderservice.service;

import com.fernando.bookstore.orderservice.data.dto.ConfirmOrderPaymentDTO;
import com.fernando.bookstore.orderservice.data.dto.CreateOrderDTO;
import com.fernando.bookstore.orderservice.data.dto.OrderDeliveredDTO;
import com.fernando.bookstore.orderservice.data.model.Order;
import com.fernando.services.commons.api.service.DefaultService;

public interface OrderService extends DefaultService<Order, String> {

    public Order createOrder(CreateOrderDTO createOrderDTO);

    public Order confirmOrderPayment(ConfirmOrderPaymentDTO confirmPaymentDTO);

    
    public Order confirmOrderDelivery(OrderDeliveredDTO orderDeliveredDTO);
    
}
