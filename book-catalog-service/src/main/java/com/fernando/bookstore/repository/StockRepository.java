package com.fernando.bookstore.repository;


import java.util.List;

import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.Stock;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StockRepository extends PagingAndSortingRepository<Stock, String> {
    
}
