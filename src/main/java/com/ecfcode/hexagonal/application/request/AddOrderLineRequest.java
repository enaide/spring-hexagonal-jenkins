package com.ecfcode.hexagonal.application.request;

import com.ecfcode.hexagonal.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record AddOrderLineRequest(@JsonProperty("product") Product product, @JsonProperty("quantity") int quantity) {
    public AddOrderLineRequest {
        Objects.requireNonNull(product);
    }
}
