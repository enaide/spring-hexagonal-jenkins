package com.ecfcode.hexagonal.infrastracture.entities.concretes;

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
	private int orderId;
	
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
	

}
