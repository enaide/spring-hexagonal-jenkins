package com.ecfcode.hexagonal.infrastracture.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail {

	@Id
    @Column(name="order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name="order_id",insertable = false, updatable = false)
    private Order order;

    @Id
    @Column(name="product_id")
    private int productId;

    @ManyToOne
    @JoinColumn(name="product_id",insertable = false, updatable = false)
    private Product product;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="discount")
	private double discount;
	
}
