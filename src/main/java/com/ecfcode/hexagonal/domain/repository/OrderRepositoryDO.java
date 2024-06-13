package com.ecfcode.hexagonal.domain.repository;

import com.ecfcode.hexagonal.domain.models.OrderDO;

import java.util.Optional;

public interface OrderRepositoryDO {
    Optional<OrderDO> findById(Long id);

    OrderDO save(OrderDO order);
}
