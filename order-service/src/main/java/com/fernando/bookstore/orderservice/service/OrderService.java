package com.fernando.bookstore.orderservice.service;

import com.fernando.bookstore.orderservice.data.dto.ConfirmOrderPaymentDTO;
import com.fernando.bookstore.orderservice.data.dto.CreateOrderDTO;
import com.fernando.bookstore.orderservice.data.model.Order;

public interface OrderService {

    public Order createOrder(CreateOrderDTO createOrderDTO);

    public Order confirmOrderPayment(ConfirmOrderPaymentDTO confirmPaymentDTO);
    
}
