package com.fernando.bookstore.service;

import java.util.List;

import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.StockIn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    public Book get(String id);

    public Page<Book> getAll();

    public Page<Book> getAll(Pageable pageable);
    
    public Page<Book> getAll(int page, int size, String... sort);

    public Book create(Book book);

    public Book update(Book book);

    public List<StockIn> getStockInsByBookId(String bookId);
}
