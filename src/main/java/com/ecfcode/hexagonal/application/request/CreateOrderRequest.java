package com.ecfcode.hexagonal.application.request;

import com.ecfcode.hexagonal.domain.entities.OrderLine;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record CreateOrderRequest(@JsonProperty("orderLine") OrderLine orderLine) {
    public CreateOrderRequest{
        Objects.requireNonNull(orderLine);
    }
}
