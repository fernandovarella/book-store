package com.fernando.bookstore.data.dto;

import com.fernando.bookstore.data.model.StockInTypeEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockInDTO {
    
    private String bookId;
    private Long quantity;
    private StockInTypeEnum type;

}
