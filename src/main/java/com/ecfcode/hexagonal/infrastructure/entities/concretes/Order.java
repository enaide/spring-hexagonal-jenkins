package com.ecfcode.hexagonal.infrastructure.entities.concretes;

import com.ecfcode.hexagonal.domain.models.OrderDO;
import com.ecfcode.hexagonal.domain.models.OrderLineDO;
import com.ecfcode.hexagonal.domain.models.ProductDO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
	@JoinColumn(name="employee_id", nullable = false,
			referencedColumnName = "employee_id",
			foreignKey = @ForeignKey(
					name = "employee_id_fk"
			))
	private Employee employee;

	@ManyToOne
	@JoinColumn(name="customer_number", nullable = false,
			referencedColumnName = "customer_number",
			foreignKey = @ForeignKey(
					name = "customer_number_fk"
			))
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetails;

	public Order(OrderDO order) {
		this.orderId = order.getOrderId();
		this.orderDate = order.getOrderDate();
		this.requiredDate = order.getRequiredDate();
		this.shippedDate = order.getShippedDate();
	}

	public OrderDO toOrder() {
		List<OrderLineDO> orderItems = orderDetails.stream()
				.map(OrderDetail::toOrderLine)
				.toList();

		List<ProductDO> namelessProducts = orderItems.stream()
				.map(orderItem -> new ProductDO(orderItem.getProduct().getProductId(), orderItem.getProduct().getPrice())).toList();

		OrderDO order = new OrderDO(orderItems);
//		namelessProducts.forEach(product -> order.addOrder(product));
//		if (status == OrderStatus.COMPLETED) {
//			order.complete();
//		}
		return order;
	}
}
