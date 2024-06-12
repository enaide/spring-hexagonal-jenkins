package com.ecfcode.hexagonal.infrastracture.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	Customer findByCustomerNumber(String id);
}
