package com.ecfcode.hexagonal.infrastracture.repository.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.codejava.demo.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
