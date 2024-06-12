package com.ecfcode.hexagonal.infrastracture.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int orderId;
	private int productId;
}
