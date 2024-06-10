package com.ecfcode.hexagonal.infrastracture.entities.codejava.sale;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailID implements Serializable {

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderDetailID() {
    }

    public OrderDetailID(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailID that = (OrderDetailID) o;
        return Objects.equals(product, that.product) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }

    @Override
    public String toString() {
        return "OrderDetailID{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }
}
