package com.ecfcode.hexagonal.infrastructure.abstracts;

import com.ecfcode.hexagonal.infrastructure.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCustomerNumber(String id);
}
