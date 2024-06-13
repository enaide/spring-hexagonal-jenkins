package com.ecfcode.hexagonal.domain.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductDO {

    private final Long productId;
    private final BigDecimal price;
    private String productName;
    private double unitPrice;
    private int unitsInStock;
    private int discontinued;
    private int unitsOnOrder;
    private String quantityPerUnit ;

    @JsonCreator
    public ProductDO(@JsonProperty("id") final Long productId, @JsonProperty("price") final BigDecimal price) {
        this.productId = productId;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getProductId() {
        return productId;
    }

    public int getDiscontinued() {
        return discontinued;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public int getUnitsOnOrder() {
        return unitsOnOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDO product = (ProductDO) o;
        return Objects.equals(productId, product.productId) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, price);
    }

    @Override
    public String toString() {
        return "ProductDO{" +
                "discontinued=" + discontinued +
                ", productId=" + productId +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", unitsInStock=" + unitsInStock +
                ", unitsOnOrder=" + unitsOnOrder +
                ", quantityPerUnit='" + quantityPerUnit + '\'' +
                '}';
    }
}
