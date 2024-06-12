package com.ecfcode.hexagonal.domain.requests.demo;

import com.ecfcode.hexagonal.domain.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record AddOrderLineRequest(@JsonProperty("product") Product product, @JsonProperty("quantity") int quantity) {
    public AddOrderLineRequest {
        Objects.requireNonNull(product);
    }
}
