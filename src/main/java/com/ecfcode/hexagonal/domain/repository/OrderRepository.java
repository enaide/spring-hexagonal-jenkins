package com.ecfcode.hexagonal.domain.repository;

import com.ecfcode.hexagonal.domain.models.Order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(Long id);

    Order save(Order order);
}
