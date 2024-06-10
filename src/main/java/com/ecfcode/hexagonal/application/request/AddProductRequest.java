package com.ecfcode.hexagonal.application.request;

import com.ecfcode.hexagonal.domain.entities.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record AddProductRequest(@JsonProperty("product") Product product) {
    public AddProductRequest{
        Objects.requireNonNull(product);
    }
}
