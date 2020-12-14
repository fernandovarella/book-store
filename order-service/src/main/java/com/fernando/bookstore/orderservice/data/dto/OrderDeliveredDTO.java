package com.fernando.bookstore.orderservice.data.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Builder
@Data
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class OrderDeliveredDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String orderId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime deliveryDateTime;

}
