package com.ecfcode.hexagonal.infrastracture.entities.codejava.sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
