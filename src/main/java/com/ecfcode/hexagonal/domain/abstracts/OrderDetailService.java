package com.ecfcode.hexagonal.domain.abstracts;

import com.ecfcode.hexagonal.domain.requests.orderDetails.CreateOrderDetailRequest;
import com.ecfcode.hexagonal.domain.requests.orderDetails.DeleteOrderDetailRequest;
import com.ecfcode.hexagonal.domain.requests.orderDetails.UpdateOrderDetailRequest;
import com.ecfcode.hexagonal.domain.responses.orderDetails.OrderDetailGetResponse;
import com.ecfcode.hexagonal.domain.responses.orderDetails.OrderDetailListResponse;
import com.ecfcode.hexagonal.core.utilities.results.DataResult;
import com.ecfcode.hexagonal.core.utilities.results.Result;

import java.util.List;

public interface OrderDetailService {

	Result add(CreateOrderDetailRequest createOrderDetailRequest);
	Result delete(DeleteOrderDetailRequest deleteOrderDetailRequest);
	Result update(UpdateOrderDetailRequest updateOrderDetailRequest);
	
	DataResult<OrderDetailGetResponse> getById(Long orderId,int productId);
	DataResult<List<OrderDetailListResponse>> getAll();
}
