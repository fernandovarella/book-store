package com.fernando.bookstore.data.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "stockIns")
public class StockIn extends DefaultEntity {

    private static final long serialVersionUID = 1L;

    private String bookId;
    
    private Long quantity;
    
    private StockInTypeEnum type;

}
