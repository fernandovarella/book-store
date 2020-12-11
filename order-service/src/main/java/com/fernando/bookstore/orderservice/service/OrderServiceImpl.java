package com.fernando.bookstore.orderservice.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fernando.bookstore.orderservice.data.dto.ConfirmOrderPaymentDTO;
import com.fernando.bookstore.orderservice.data.dto.CreateOrderDTO;
import com.fernando.bookstore.orderservice.data.model.Order;
import com.fernando.bookstore.orderservice.data.model.OrderStatusEnum;
import com.fernando.bookstore.orderservice.repository.OrderRepository;
import com.fernando.services.commons.api.exception.EntityNotFoundException;
import com.fernando.services.commons.api.service.DefaultServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl extends DefaultServiceImpl<Order,String> implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public Order createOrder(CreateOrderDTO createOrderDTO) {
        BigDecimal totalPrice = createOrderDTO.getBooks().stream()  
            .map(orderBook -> orderBook.getOrderPrice().multiply(new BigDecimal(orderBook.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order = Order.builder()
            .books(createOrderDTO.getBooks())
            .status(OrderStatusEnum.CREATED)
            .orderDate(LocalDate.now())
            .totalPrice(totalPrice)
            .build();

        order = repository.save(order);
            
        return order;
    }

    @Override
    public Order confirmOrderPayment(ConfirmOrderPaymentDTO confirmPaymentDTO) {
        Order order = repository.findById(confirmPaymentDTO.getOrderId()).orElseThrow(EntityNotFoundException::new);
        order.setStatus(OrderStatusEnum.PAYMENT_CONFIRMED);
        order.setPaymentDate(confirmPaymentDTO.getPaymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        order = repository.save(order);
        return order;
    }
    
}
