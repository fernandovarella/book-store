package com.fernando.bookstore.service;

import java.util.List;

import com.fernando.bookstore.api.exception.EntityNotFoundException;
import com.fernando.bookstore.data.dto.StockDTO;
import com.fernando.bookstore.data.dto.StockInDTO;
import com.fernando.bookstore.data.model.Book;
import com.fernando.bookstore.data.model.Stock;
import com.fernando.bookstore.data.model.StockIn;
import com.fernando.bookstore.data.model.StockOut;
import com.fernando.bookstore.repository.StockInRepository;
import com.fernando.bookstore.repository.StockOutRepository;
import com.fernando.bookstore.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockInRepository stockInRepository;
    @Autowired
    private StockOutRepository stockOutRepository;
    @Autowired
    private BookService bookService;


	@Override
	public Stock getByBookId(String bookId) {
		Stock stock = bookService.get(bookId).getStock();
		if (stock == null) {
			throw new EntityNotFoundException("Book does not have an associated Stock");
		}
		return stock;
	}

	@Override
	public Page<StockIn> getStockInsByBookId(String bookId, Pageable pageable) {
		return stockInRepository.findAllByBookId(bookId, pageable);
	}

	@Override
	public List<StockOut> getStockOutsByBook(String bookId) {
		return bookService.get(bookId).getStockOuts();
	}
	
	// @Override
	// public Page<StockIn> getStockInsByBookId(String bookId, Pageable pageable) {
    //     Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " does not exist"));
    //     return stockInRepository.findAllByBook(book);
    // }
    
	// @Override
	// public List<StockOut> findStockOutsByBook(String bookId, int page, int size, String... sort) {
	// 	Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " does not exist");
    //     return stockOutRepository.findAllByBook(book);
	// }

	@Override
	public Stock createStockIn(StockInDTO stockInDTO) {
		Book book = bookService.get(stockInDTO.getBookId());
		StockIn stockIn = StockIn.builder()
			.bookId(book.getId())
			.quantity(stockInDTO.getQuantity())
			.type(stockInDTO.getType())
			.build();
		// StockIn stockIn = new StockIn(book, stockInDTO.getQuantity(), stockInDTO.getType());
		
		Stock stock = book.getStock();
		if (stock == null) {
			stock = new Stock();
			stock.setQuantity(0l);
		}
		stock.setQuantity(stock.getQuantity() + stockIn.getQuantity());

		stockIn = stockInRepository.save(stockIn);
		book.getStockIns().add(stockIn);
		bookService.update(book);

		return stock;
	}

	// @Override
	// public Stock createStockOut(StockOut stockOut) {
	// 	throw new UnsupportedOperationException();
	// }

	@Override
	public Stock createStock(StockDTO stockDTO) {
		Book book = bookService.get(stockDTO.getBookId());
		Stock stock = Stock.builder().quantity(stockDTO.getQuantity()).build();
		book.setStock(stock);
		bookService.update(book);
		return stock;
	}
    
}
