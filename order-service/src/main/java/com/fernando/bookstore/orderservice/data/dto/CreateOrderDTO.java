package com.fernando.bookstore.orderservice.data.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fernando.bookstore.orderservice.data.model.OrderBook;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Builder
@Value
public class CreateOrderDTO {
    
    private String userId;
    private List<OrderBook> books;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date createdDate;

}
