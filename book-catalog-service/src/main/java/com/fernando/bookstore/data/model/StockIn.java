package com.fernando.bookstore.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fernando.services.commons.api.model.DefaultEntity;

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
public class StockIn extends DefaultEntity<String> {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Field("id")
    private String id; 

    private String bookId;
    
    private Long quantity;
    
    private StockInTypeEnum type;

}
