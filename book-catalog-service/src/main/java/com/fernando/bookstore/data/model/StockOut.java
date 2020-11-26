package com.fernando.bookstore.data.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(buildMethodName = "stockOutBuilder")
@Document(value = "stockOuts")
public class StockOut extends DefaultEntity {

    private static final long serialVersionUID = 1L;

    @DBRef
    private Book book;

    @DBRef
    private Stock stock;

    private Long quantity;


}
