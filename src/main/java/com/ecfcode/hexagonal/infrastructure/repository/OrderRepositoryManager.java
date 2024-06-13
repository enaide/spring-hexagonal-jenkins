package com.ecfcode.hexagonal.infrastructure.repository;

import com.ecfcode.hexagonal.domain.models.OrderDO;

import com.ecfcode.hexagonal.domain.repository.OrderRepositoryDO;
import com.ecfcode.hexagonal.infrastructure.abstracts.OrderRepository;
import com.ecfcode.hexagonal.infrastructure.entities.concretes.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryManager implements OrderRepositoryDO {

    private final OrderRepository orderRepository;

    public OrderRepositoryManager(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<OrderDO> findById(Long id) {
        Optional<Order> orderEntity = orderRepository.findById(id);
        if (orderEntity.isPresent()) {
            return Optional.of(orderEntity.get().toOrder());
        } else {
            return Optional.empty();
        }
    }

    @Override
    public OrderDO save(OrderDO order) {
        return null;
    }
}
