package com.ecfcode.hexagonal.infrastracture.demo;

import com.ecfcode.hexagonal.infrastracture.demo.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
