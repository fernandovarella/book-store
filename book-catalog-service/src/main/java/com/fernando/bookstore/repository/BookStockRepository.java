package com.fernando.bookstore.repository;


import com.fernando.bookstore.data.model.Book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

// public interface BookRepository extends PagingAndSortingRepository<Book, String> {

public interface BookStockRepository extends MongoRepository<Book, String> {
    
  @Query(value = "{ _id : ?0 }",fields = "{ stock: 1 }")
  public Book findStockByBookId(String bookId); 
  
  @Query(value = "{ _id : ?0 }",fields = "{ stockIns: 1 }")
  public Book findStockInsByBookId(String bookId);

    
  @Query(value = "{ _id : ?0 }",fields = "{ stockOuts: 1 }")
  public Book findStockOutsByBookId(String bookId);
}