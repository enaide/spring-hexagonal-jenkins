package com.ecfcode.hexagonal.domain.requests.demo;

import com.ecfcode.hexagonal.domain.models.ProductDO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public record AddProductRequest(@JsonProperty("product") ProductDO product) {
    public AddProductRequest{
        Objects.requireNonNull(product);
    }
}
