package com.fernando.bookstore.repository;

import java.util.ArrayList;
import java.util.List;

import com.fernando.bookstore.data.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryCustom {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Book> findByCustomQuery(String isbn, String title, String author, Pageable pageable) {
        Query query = new Query().with(pageable);
        final List<Criteria> criterias = new ArrayList<>();

        if (isbn != null) {
            criterias.add(Criteria.where("isbn").is(isbn));
        }
        if (title != null) {
            criterias.add(Criteria.where("title").regex(".*" + title + ".*", "i"));
        }
        if (author != null) {
            criterias.add(Criteria.where("author").regex(".*" + author + ".*", "i"));
        }
        
        if (!criterias.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criterias.toArray(new Criteria[criterias.size()])));
        }
        return mongoTemplate.find(query, Book.class);
    }

}
