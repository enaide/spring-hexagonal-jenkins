package com.ecfcode.hexagonal.infrastructure.demo.repository;

import com.ecfcode.hexagonal.infrastructure.demo.entities.CustomerDemo;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDemoRepository extends CrudRepository<CustomerDemo, Long> {
}
