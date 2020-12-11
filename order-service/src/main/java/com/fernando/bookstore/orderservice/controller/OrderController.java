package com.fernando.bookstore.orderservice.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.fernando.bookstore.orderservice.data.dto.CreateOrderDTO;
import com.fernando.bookstore.orderservice.data.model.Order;
import com.fernando.bookstore.orderservice.service.OrderService;

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
@RequestMapping(path = "v1/orders", produces = APPLICATION_JSON_VALUE)
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable(value = "orderId") String orderId) {
		return ResponseEntity.ok(orderService.get(orderId));
	}

	@GetMapping(path = "")
	public ResponseEntity<Page<Order>> getOrders(Pageable pageable) {
		return ResponseEntity.ok(orderService.list(pageable));
	}
	

    @PostMapping(path = "")
	public ResponseEntity<Order> create(@RequestBody CreateOrderDTO createOrderDTO) {
		return ResponseEntity.ok(orderService.createOrder(createOrderDTO));
	}

	
	// @GetMapping(path = "/test")
	// public ResponseEntity<List<CountOrdersPerAuthorDTO>> test(@RequestParam(defaultValue = "0.0") Double minAvgCost) {
	// 	// List<Order> ret = OrderRepository.getTitleAndRating();
	// 	// List<CountOrdersPerAuthorDTO> ret = OrderRepository.countOrdersByAuthorWithAverageRatingGtThan(4.7);

	// 	// return ResponseEntity.ok(ret);
	// 	return ResponseEntity.ok(orderRepository.countOrdersByAuthorWithAverageRatingGtThan(minAvgCost)); 
	// }
	

}
