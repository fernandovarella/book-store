package com.fernando.bookstore.data.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String bookId;

    private Long quantity;

}
