package com.ecfcode.hexagonal.infrastracture.entities.codejava.sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
