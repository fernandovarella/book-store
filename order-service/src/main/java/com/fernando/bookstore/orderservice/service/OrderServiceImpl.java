package com.fernando.bookstore.orderservice.service;

import java.math.BigDecimal;
import java.time.ZoneId;

import javax.annotation.PostConstruct;

import com.fernando.bookstore.orderservice.api.BusinessException;
import com.fernando.bookstore.orderservice.data.dto.ConfirmOrderPaymentDTO;
import com.fernando.bookstore.orderservice.data.dto.CreateOrderDTO;
import com.fernando.bookstore.orderservice.data.dto.OrderDeliveredDTO;
import com.fernando.bookstore.orderservice.data.model.Order;
import com.fernando.bookstore.orderservice.data.model.OrderStatusEnum;
import com.fernando.bookstore.orderservice.messaging.OrdersMessagesSender;
import com.fernando.bookstore.orderservice.messaging.dto.OrderConfirmedMsg;
import com.fernando.bookstore.orderservice.repository.OrderRepository;
import com.fernando.services.commons.api.exception.EntityNotFoundException;
import com.fernando.services.commons.api.service.DefaultServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends DefaultServiceImpl<Order,String> implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrdersMessagesSender ordersMessagesSender;

    @Override
    @PostConstruct
    public void initRepository() {
        super.setRepository(repository);
    }

    @Override
    public Order createOrder(CreateOrderDTO createOrderDTO) {
        BigDecimal totalPrice = createOrderDTO.getBooks().stream()  
            .map(orderBook -> orderBook.getOrderPrice().multiply(new BigDecimal(orderBook.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        Order order = Order.builder()
            .books(createOrderDTO.getBooks())
            .status(OrderStatusEnum.CREATED)
            // .orderDate(createOrderDTO.getCreatedDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
            .orderDate(createOrderDTO.getCreatedDate())
            .totalPrice(totalPrice)
            .build();

        order = repository.save(order);

        ordersMessagesSender.sendOrderConfirmed(OrderConfirmedMsg.builder().orderId(order.getId()).status(order.getStatus()).build());
            
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

    @Override
    public Order confirmOrderDelivery(OrderDeliveredDTO orderDeliveredDTO) {
        Order order = repository.findById(orderDeliveredDTO.getOrderId()).orElseThrow(EntityNotFoundException::new);
        if (!OrderStatusEnum.CREATED.equals(order.getStatus())) {
            throw new BusinessException("Order must be on status CREATED in order to have it's delivery confirmed.");
        }
        order.setStatus(OrderStatusEnum.DELIVERED);
        order.setDeliveryDateTime(orderDeliveredDTO.getDeliveryDateTime());
        order = repository.save(order);
        return order;
    }
    
}
