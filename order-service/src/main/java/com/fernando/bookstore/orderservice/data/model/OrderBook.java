package com.fernando.bookstore.orderservice.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBook implements Serializable {

    private static final long serialVersionUID = 4773114691880555695L;

    private String uid;

    private Long quantity;

    private BigDecimal orderPrice;

    private BigDecimal listPrice;

    
}
