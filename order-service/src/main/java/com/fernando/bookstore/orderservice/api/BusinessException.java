package com.fernando.bookstore.orderservice.api;

import com.fernando.services.commons.api.exception.ApiException;

public class BusinessException extends ApiException {
    
    private static final long serialVersionUID = 1L;

    public BusinessException() {
    }
    public BusinessException(String message) {
        super(message);
    }
    
}
