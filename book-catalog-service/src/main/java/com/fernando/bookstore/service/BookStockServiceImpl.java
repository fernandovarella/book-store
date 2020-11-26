package com.fernando.bookstore.service;

import java.util.List;

import com.fernando.bookstore.data.dto.StockInDTO;
import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.Stock;
import com.fernando.bookstore.data.model.StockIn;
import com.fernando.bookstore.data.model.StockOut;
import com.fernando.bookstore.repository.StockInRepository;
import com.fernando.bookstore.repository.StockOutRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class BookStockServiceImpl implements BookStockService {

    @Autowired
    private BookService bookService;

    @Autowired
    private StockInRepository stockInRepository;

    @Autowired
    private StockOutRepository stockOutRepository;

    public Stock getStockByBook(String bookId) {
        Book book = bookService.get(bookId);
        return book.getStock();
    }

    public List<StockIn> getStockInsByBook(String bookId) {
        return stockInRepository.findAllByBookId(bookId);
    }

    public List<StockOut> getStockOutsByBook(String bookId) {
        return stockOutRepository.findAllByBook(bookService.get(bookId));

    }

    public Book createStockIn(StockInDTO stockInDTO) {
        throw new UnsupportedOperationException();
    }

}
