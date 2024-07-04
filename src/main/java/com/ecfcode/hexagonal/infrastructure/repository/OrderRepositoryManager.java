package com.ecfcode.hexagonal.infrastructure.repository;

import com.ecfcode.hexagonal.domain.models.OrderDO;

import com.ecfcode.hexagonal.domain.repository.OrderRepositoryDO;
import com.ecfcode.hexagonal.infrastructure.abstracts.OrderRepository;
import com.ecfcode.hexagonal.infrastructure.entities.concretes.Order;
import com.ecfcode.hexagonal.infrastructure.entities.mappers.OrderDOMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderRepositoryManager implements OrderRepositoryDO {

    private final OrderRepository orderRepository;
    private final OrderDOMapper orderDOMapper;

    public OrderRepositoryManager(OrderRepository orderRepository, OrderDOMapper orderDOMapper) {
        this.orderRepository = orderRepository;
        this.orderDOMapper = orderDOMapper;
    }

    @Override
    public Optional<OrderDO> findById(Long id) {
        Optional<OrderDO> order = orderRepository.findById(id).map(orderDOMapper);

        if (order.isPresent()) {
            return order;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public OrderDO save(OrderDO order) {
        Order o =  orderRepository.save(new Order(order));
        return o.toOrder();
    }
}
