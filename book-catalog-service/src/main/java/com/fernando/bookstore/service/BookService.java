package com.fernando.bookstore.service;

import java.util.List;

import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.StockIn;
import com.fernando.services.commons.api.service.DefaultService;

public interface BookService extends DefaultService<Book, String> {

    public List<StockIn> getStockInsByBookId(String bookId);
}
