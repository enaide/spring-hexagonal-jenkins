package com.ecfcode.hexagonal.infrastracture.repository.concretes;

import com.ecfcode.hexagonal.domain.models.Order;
import com.ecfcode.hexagonal.domain.repository.OrderRepository;
import com.ecfcode.hexagonal.infrastracture.repository.abstracts.OrderRepositoryImpDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryImp implements OrderRepository {

    private final OrderRepositoryImpDB orderRepository;

    @Autowired
    public OrderRepositoryImp(OrderRepositoryImpDB orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Order save(Order order) {
        return null;
    }
}
