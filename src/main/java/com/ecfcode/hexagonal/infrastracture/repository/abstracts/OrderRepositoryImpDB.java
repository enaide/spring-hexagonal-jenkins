package com.ecfcode.hexagonal.infrastracture.repository.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// todo change Employee entity for OrderEntity
public interface OrderRepositoryImpDB extends JpaRepository<Employee, Long> {
}
