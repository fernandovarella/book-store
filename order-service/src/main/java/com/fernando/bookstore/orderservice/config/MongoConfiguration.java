package com.fernando.bookstore.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.fernando.bookstore.orderservice")
@EnableMongoAuditing
public class MongoConfiguration {
    
}