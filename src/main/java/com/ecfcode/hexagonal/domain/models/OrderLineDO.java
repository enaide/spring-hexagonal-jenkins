package com.ecfcode.hexagonal.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderLineDO {

    private Long orderLineId;
    private final int quantity;
    private BigDecimal discount;

    private final ProductDO product;
    // TODO
    // private final OrderDO order;

    @JsonCreator
    public OrderLineDO(
            @JsonProperty("product") final ProductDO product,
            @JsonProperty("quantity") final int quantity) {

        this.product = product;
        this.quantity = quantity;
    }

    @JsonCreator
    public OrderLineDO(
            @JsonProperty("product") final ProductDO product,
            @JsonProperty("quantity") final int quantity,
            @JsonProperty("discount") final BigDecimal discount) {

        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Long getOrderLineId() {
        return orderLineId;
    }

    BigDecimal cost() {
        return product.getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }

    public ProductDO getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineDO that = (OrderLineDO) o;
        return quantity == that.quantity && Objects.equals(orderLineId, that.orderLineId) && Objects.equals(discount, that.discount) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, quantity, discount, product);
    }

    @Override
    public String toString() {
        return "OrderLineDO{" +
                "discount=" + discount +
                ", orderLineId=" + orderLineId +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
