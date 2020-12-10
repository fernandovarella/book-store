package com.fernando.bookstore.orderservice.repository;

import com.fernando.bookstore.orderservice.data.model.Order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    
}