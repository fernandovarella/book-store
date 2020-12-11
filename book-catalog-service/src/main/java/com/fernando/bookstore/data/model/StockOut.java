package com.fernando.bookstore.data.model;

import com.fernando.services.commons.api.model.DefaultEntity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(buildMethodName = "stockOutBuilder")
@Document(value = "stockOuts")
public class StockOut extends DefaultEntity<String> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Field("id")
    private String id; 

    @DBRef
    private Book book;

    @DBRef
    private Stock stock;

    private Long quantity;


}
