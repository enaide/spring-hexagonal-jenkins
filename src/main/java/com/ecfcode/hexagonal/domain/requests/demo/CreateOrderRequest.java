package com.ecfcode.hexagonal.domain.requests.demo;

import com.ecfcode.hexagonal.domain.models.OrderLine;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record CreateOrderRequest(@JsonProperty("orderLine") OrderLine orderLine) {
    public CreateOrderRequest{
        Objects.requireNonNull(orderLine);
    }
}
