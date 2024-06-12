package com.ecfcode.hexagonal.domain.requests.demo;

import com.ecfcode.hexagonal.domain.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record AddProductRequest(@JsonProperty("product") Product product) {
    public AddProductRequest{
        Objects.requireNonNull(product);
    }
}
