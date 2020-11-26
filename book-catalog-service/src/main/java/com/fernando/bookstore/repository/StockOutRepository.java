package com.fernando.bookstore.repository;


import java.util.List;

import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.StockOut;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockOutRepository extends MongoRepository<StockOut, String> {
    
    public List<StockOut> findAllByBook(Book book);
}
