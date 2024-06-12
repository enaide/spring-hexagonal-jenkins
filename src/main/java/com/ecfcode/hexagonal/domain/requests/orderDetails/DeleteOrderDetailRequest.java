package com.ecfcode.hexagonal.domain.requests.orderDetails;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteOrderDetailRequest {

	@Positive
	private int orderId;
	
	@Positive
	private int productId;
}
