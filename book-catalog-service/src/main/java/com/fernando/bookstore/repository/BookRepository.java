package com.fernando.bookstore.repository;


import java.util.List;

import com.fernando.bookstore.data.dto.CountBooksPerAuthorDTO;
import com.fernando.bookstore.data.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

// public interface BookRepository extends PagingAndSortingRepository<Book, String> {

public interface BookRepository extends MongoRepository<Book, String> {
    
    public Book findByTitle(String title);

    
    @Aggregation("{ $project: { title: 1, average_rating: 1, ratings_count: 1 } }")
    public List<Book> getTitleAndRating();
    
    // @Aggregation("[{$match: {  average_rating: { $gt: 4.0}}}, {$unwind: {  path: '$authors',  includeArrayIndex: 'authorIdx',  preserveNullAndEmptyArrays: false}}, {$project: {  average_rating: 1, title: 1, authors: 1  }}, {$group: {  _id: '$authors',  count: { $sum: 1}}}, {$sort: {  count: -1}}]")
    @Aggregation(pipeline = {
      "{$match: {  average_rating: { $gt: ?0}}}",
       "{$unwind: {  path: '$authors',  includeArrayIndex: 'authorIdx',  preserveNullAndEmptyArrays: false}}",
       "{$project: {  average_rating: 1, title: 1, authors: 1  }}", 
       "{$group: {  _id: '$authors',  count: { $sum: 1}}}",
       "{$sort: {  count: -1}}" })
    public List<CountBooksPerAuthorDTO> countBooksByAuthorWithAverageRatingGtThan(Double minAvgRating);

}