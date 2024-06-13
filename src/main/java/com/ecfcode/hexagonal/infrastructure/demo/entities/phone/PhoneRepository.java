package com.ecfcode.hexagonal.infrastructure.demo.entities.phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, PhoneID> {

}
