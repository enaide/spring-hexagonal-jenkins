package com.ecfcode.hexagonal.infrastracture.repository;

import com.ecfcode.hexagonal.domain.entities.Order;
import com.ecfcode.hexagonal.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImp implements OrderRepository {
    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order save(Order order) {
        return null;
    }
}
