package com.fernando.bookstore.orderservice.data.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Getter
@Setter
@Builder
@Value
public class ConfirmOrderPaymentDTO {
    
    private String orderId;
    
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date paymentDate;

}
