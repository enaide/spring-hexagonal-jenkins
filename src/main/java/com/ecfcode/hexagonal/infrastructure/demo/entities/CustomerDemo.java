package com.ecfcode.hexagonal.infrastructure.demo.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class CustomerDemo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Collection<Sale> sales = new ArrayList<>();

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Collection<Sale> getSales() {
        return sales;
    }

    public void addSale(Sale sale) {
        if(!sales.contains(sale)) {
            sales.add(sale);
            sale.setCustomer(this);
        }
    }

    public void removeSale(Sale sale) {
        sales.remove(sale);
    }

    public void setSales(Collection<Sale> sales) {
        this.sales = sales;
    }
}
