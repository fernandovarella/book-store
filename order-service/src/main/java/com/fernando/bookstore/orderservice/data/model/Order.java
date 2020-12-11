package com.fernando.bookstore.orderservice.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fernando.services.commons.api.model.DefaultEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Document(value = "orders")
@JsonInclude(Include.NON_ABSENT)
public class Order extends DefaultEntity<String> implements Serializable  {
    
    private static final long serialVersionUID = -549855829265972445L;
    
    @Id
    private String id;

    @Builder.Default
    private OrderStatusEnum status = OrderStatusEnum.CREATED;
    
    @Builder.Default
    private Boolean canceled = Boolean.FALSE;

    private LocalDate orderDate;
    private LocalDate paymentDate;
    private LocalDate shippingDate;
    private LocalDate deliveryDate;

    private List<OrderBook> books;

    private BigDecimal totalPrice;

    private Customer customer;

    //shipping address,

}
