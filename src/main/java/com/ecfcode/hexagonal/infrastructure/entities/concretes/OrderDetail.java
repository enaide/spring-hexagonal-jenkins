package com.ecfcode.hexagonal.infrastructure.entities.concretes;

import com.ecfcode.hexagonal.domain.models.OrderLineDO;
import com.ecfcode.hexagonal.domain.models.ProductDO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Entity
@Table(name = "order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderDetailId.class)
public class OrderDetail {

    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false,
            referencedColumnName = "order_id",
            foreignKey = @ForeignKey(
                    name = "order_details_order_fk"
            ))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false, nullable = false,
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "order_details_product_fk"
            ))
    private Product product;

    public OrderDetail(final OrderLineDO orderLine) {
        // TODO
//        this.orderId = orderLine.getOrderLineId();
//        this.order = new Order(orderLine.getOrder());
//
//        this.productId = orderLine.getProduct().getProductId();
//        this.product = new Product(orderLine.getProduct());
//
//        this.quantity = orderLine.getQuantity();
//        this.discount = orderLine.getDiscount();
//        this.product = new Product(orderLine.getProduct());
    }

    public OrderLineDO toOrderLine() {
        return new OrderLineDO(orderId, product.toProductDO(), discount, quantity, unitPrice );
    }

    public OrderLineDO toOrderLineObject() {
        // TODO REVIEW INFINITE LOOP BETWEEN ENTITIES
        return new OrderLineDO(order.toOrder(), product.toProductDO(), discount, quantity, unitPrice );
    }
}
