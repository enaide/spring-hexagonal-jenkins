package com.ecfcode.hexagonal.infrastructure.abstracts;

import com.ecfcode.hexagonal.infrastructure.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>{

	Optional<Order> findById(Long id);
}
