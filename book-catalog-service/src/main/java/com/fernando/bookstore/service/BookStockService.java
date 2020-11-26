package com.fernando.bookstore.service;

import java.util.List;

import com.fernando.bookstore.data.dto.StockInDTO;
import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.Stock;
import com.fernando.bookstore.data.model.StockIn;
import com.fernando.bookstore.data.model.StockOut;

public interface BookStockService {

    public Stock getStockByBook(String bookId);

    public List<StockIn> getStockInsByBook(String bookId);

    public List<StockOut> getStockOutsByBook(String bookId);

    public Book createStockIn(StockInDTO stockInDTO);

}
