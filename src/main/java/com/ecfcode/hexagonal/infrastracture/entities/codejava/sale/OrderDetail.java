package com.ecfcode.hexagonal.infrastracture.entities.codejava.sale;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailID id;

    private int quantity;
    private double unitPrice;
    private float subtotal;

    public OrderDetail() {
    }

    public OrderDetail(int quantity, double unitPrice) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderDetailID getId() {
        return id;
    }

    public void setId(OrderDetailID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return quantity == that.quantity && Double.compare(unitPrice, that.unitPrice) == 0 && Float.compare(subtotal, that.subtotal) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, unitPrice, subtotal);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                '}';
    }
}
