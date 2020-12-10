package com.fernando.bookstore.repository;


import com.fernando.bookstore.data.model.Stock;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StockRepository extends PagingAndSortingRepository<Stock, String> {
    
}
