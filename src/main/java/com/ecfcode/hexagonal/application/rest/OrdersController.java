package com.ecfcode.hexagonal.application.rest;

import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.domain.abstracts.OrderService;
import com.ecfcode.hexagonal.domain.requests.orders.CreateOrderRequest;
import com.ecfcode.hexagonal.domain.requests.orders.DeleteOrderRequest;
import com.ecfcode.hexagonal.domain.requests.orders.UpdateOrderRequest;
import com.ecfcode.hexagonal.domain.responses.orders.OrderGetResponse;
import com.ecfcode.hexagonal.domain.responses.orders.OrderListResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

	private OrderService orderService;

	@Autowired
	public OrdersController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateOrderRequest createOrderRequest){
		return this.orderService.add(createOrderRequest);
	}
	
	@PostMapping("/delete")
	public Result delete(@Valid @RequestBody DeleteOrderRequest deleteOrderRequest){
		return this.orderService.delete(deleteOrderRequest);
	}
	
	@PostMapping("/update")
	public Result update(@Valid @RequestBody UpdateOrderRequest updateOrderRequest){
		return this.orderService.update(updateOrderRequest);
	}
	
	
	@GetMapping("/getbyid")
	public DataResult<OrderGetResponse> getById(@RequestParam Long id){
		return this.orderService.getById(id);
	}
	@GetMapping("/getall")
	public DataResult<List<OrderListResponse>> getAll(){
		return this.orderService.getAll();
	}
}
