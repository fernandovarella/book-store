package com.fernando.bookstore.orderservice.api;

import com.fernando.services.commons.api.exception.JsonApiExceptionHandler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class LocalJsonApiExceptionHandler extends JsonApiExceptionHandler {
    
}
