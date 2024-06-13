package com.ecfcode.hexagonal.infrastructure.entities.concretes;

import com.ecfcode.hexagonal.domain.models.OrderDO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	@Id
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name="order_date")
	private LocalDate orderDate;
	
	@Column(name="required_date")
	private LocalDate requiredDate;
	
	@Column(name="shipped_date")
	private LocalDate shippedDate;

	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="customer_number")
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	public Order(OrderDO order) {
		this.orderId = order.getOrderId();
		this.orderDate = order.getOrderDate();
		this.requiredDate = order.getRequiredDate();
		this.shippedDate = order.getShippedDate();
	}
}
