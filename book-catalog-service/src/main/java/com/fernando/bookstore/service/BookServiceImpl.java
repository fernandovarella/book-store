package com.fernando.bookstore.service;

import java.util.List;

import javax.annotation.PostConstruct;

import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.StockIn;
import com.fernando.bookstore.repository.BookRepository;
import com.fernando.bookstore.repository.BookRepositoryCustom;
import com.fernando.services.commons.api.service.DefaultServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends DefaultServiceImpl<Book, String> implements BookService {

    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookRepositoryCustom bookRepositoryCustom;

    @Override
    @PostConstruct
    public void initRepository() {
        super.setRepository(bookRepository);
    }

    @PostConstruct
    private void init() {
        super.setRepository(bookRepository);
    }

    @Override
    public List<StockIn> getStockInsByBookId(String bookId) {
        return get(bookId).getStockIns();
    }

    public List<Book> listWithFilters(String isbn, String title, String author, Pageable pageable) {
        return bookRepositoryCustom.findByCustomQuery(isbn, title, author, pageable);
    }
}
