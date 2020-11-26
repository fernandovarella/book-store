package com.fernando.bookstore.repository;


import java.util.List;

import com.fernando.bookstore.data.model.StockIn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockInRepository extends MongoRepository<StockIn, String> {
    
    public List<StockIn> findAllByBookId(String bookId);

    public Page<StockIn> findAllByBookId(String bookId, Pageable pageable);

}
