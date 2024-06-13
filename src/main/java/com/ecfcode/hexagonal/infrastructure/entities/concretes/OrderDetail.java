package com.ecfcode.hexagonal.infrastructure.entities.concretes;

import com.ecfcode.hexagonal.domain.models.OrderLineDO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name="order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail {

	@Id
    @Column(name="order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name="order_id",insertable = false, updatable = false)
    private Order order;

    @Id
    @Column(name="product_id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name="product_id",insertable = false, updatable = false)
    private Product product;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="discount")
	private BigDecimal discount;

    public OrderDetail(final OrderLineDO orderLine) {
        this.orderId = orderLine.getOrderLineId();
        // TODO
        // this.order = new Order(orderLine.getOrder());

        this.productId = orderLine.getProduct().getProductId();
        this.product = new Product(orderLine.getProduct());

        this.quantity = orderLine.getQuantity();
        this.discount = orderLine.getDiscount();
        this.product = new Product(orderLine.getProduct());
    }
}
