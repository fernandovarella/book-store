package com.fernando.bookstore.orderservice.data.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fernando.bookstore.orderservice.data.model.OrderBook;

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
public class CreateOrderDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String userId;
    private List<OrderBook> books;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private LocalDate createdDate;

}
