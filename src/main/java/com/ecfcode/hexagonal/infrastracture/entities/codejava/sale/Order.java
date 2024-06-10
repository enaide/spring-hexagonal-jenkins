package com.ecfcode.hexagonal.infrastracture.entities.codejava.sale;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String customerName;

    @Column(nullable = false, length = 20)
    private String status;

//    @OneToMany(
//            fetch = FetchType.EAGER,
//            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
//            mappedBy = "order"
//    )
//    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order() {
    }

    public Order(String customerName, String status) {
        this.customerName = customerName;
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(customerName, order.customerName) && Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
