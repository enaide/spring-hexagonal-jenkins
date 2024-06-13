package com.ecfcode.hexagonal.domain.requests.demo;

import com.ecfcode.hexagonal.domain.models.ProductDO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record AddOrderLineRequest(@JsonProperty("product") ProductDO product, @JsonProperty("quantity") int quantity) {
    public AddOrderLineRequest {
        Objects.requireNonNull(product);
    }
}
