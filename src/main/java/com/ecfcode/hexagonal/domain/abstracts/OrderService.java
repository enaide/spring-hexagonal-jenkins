package com.ecfcode.hexagonal.domain.abstracts;


import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;
import com.ecfcode.hexagonal.domain.requests.orders.CreateOrderRequest;
import com.ecfcode.hexagonal.domain.requests.orders.DeleteOrderRequest;
import com.ecfcode.hexagonal.domain.requests.orders.UpdateOrderRequest;
import com.ecfcode.hexagonal.domain.responses.orders.OrderGetResponse;
import com.ecfcode.hexagonal.domain.responses.orders.OrderListResponse;

import java.util.List;

public interface OrderService {

	Result add(CreateOrderRequest createOrderRequest);
	Result delete(DeleteOrderRequest deleteOrderRequest);
	Result update(UpdateOrderRequest updateOrderRequest);
	
	DataResult<OrderGetResponse> getById(int id);
	DataResult<List<OrderListResponse>> getAll();
 }
