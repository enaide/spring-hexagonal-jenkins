package com.ecfcode.hexagonal.domain.responses.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailGetResponse {

	private Long orderId;
	private double unitPrice;
	private int quantity;
	private double discount;
	private int productId;
	private String productName;

	private String categoryName;
	private String customerContactName;
}
