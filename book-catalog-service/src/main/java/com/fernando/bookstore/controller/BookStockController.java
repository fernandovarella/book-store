package com.fernando.bookstore.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.fernando.bookstore.data.dto.StockDTO;
import com.fernando.bookstore.data.dto.StockInDTO;
import com.fernando.bookstore.data.model.Stock;
import com.fernando.bookstore.data.model.StockIn;
import com.fernando.bookstore.service.BookService;
import com.fernando.bookstore.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "v1/books/{bookId}", produces = APPLICATION_JSON_VALUE)
public class BookStockController {

	@Autowired
	private BookService bookService;

	@Autowired
	private StockService stockService;
	

	@GetMapping(path = "stock")
	public ResponseEntity<Stock> getByBook(@PathVariable(value = "bookId") String bookId) {
		return ResponseEntity.ok(stockService.getByBookId(bookId));
	}

	// @GetMapping(path = "stockIns")
	// public ResponseEntity<Page<StockIn>> getStockInsByBook(@PathVariable(value = "bookId") String bookId, Pageable pageable) {
	// 	// return ResponseEntity.ok(bookRepository.findAll(ControlllerUtil.buildPageableFromRequest(page, size, sort)));
	// 	return ResponseEntity.ok(stockService.getStockInsByBookId(bookId, pageable));
	// }
	

    @PostMapping(path = "stock")
	public ResponseEntity<Stock> create(@RequestBody StockDTO stockDTO) {
		Stock created = stockService.createStock(stockDTO);
		return ResponseEntity.ok(created);
	}
	
	@GetMapping(path = "stockIns")
	public ResponseEntity<Page<StockIn>> getStockIns(@PathVariable(value = "bookId") String bookId, Pageable pageable) {
		// return ResponseEntity.ok(bookService.getStockInsByBookId(bookId));
		return ResponseEntity.ok(stockService.getStockInsByBookId(bookId, pageable));
		// return ResponseEntity.ok(null);
	}	

	@PostMapping(path = "stockIns")
	public ResponseEntity<Stock> createStockIn(@PathVariable(value = "bookId") String bookId, @RequestBody StockInDTO stockInDTO) {
		Stock created = stockService.createStockIn(stockInDTO);
		return ResponseEntity.ok(created);
	}

}
