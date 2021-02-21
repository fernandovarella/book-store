package com.fernando.bookstore.messaging.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

@Data
@Builder
// @Value
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirmedMsg implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty
    private String orderId;

    @JsonProperty
    private String status;

}
