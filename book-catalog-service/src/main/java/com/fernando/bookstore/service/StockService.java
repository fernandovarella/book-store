package com.fernando.bookstore.service;

import java.util.List;

import com.fernando.bookstore.data.dto.StockDTO;
import com.fernando.bookstore.data.dto.StockInDTO;
import com.fernando.bookstore.data.model.Stock;
import com.fernando.bookstore.data.model.StockIn;
import com.fernando.bookstore.data.model.StockOut;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StockService {

    public Stock getByBookId(String bookId);
    
    public Page<StockIn> getStockInsByBookId(String bookId, Pageable pageable);

    public List<StockOut> getStockOutsByBook(String bookId);

    public Stock createStockIn(StockInDTO stockInDTO);

    // public Stock createStockOut(StockIn stockIn);

    public Stock createStock(StockDTO stockDTO);
}
