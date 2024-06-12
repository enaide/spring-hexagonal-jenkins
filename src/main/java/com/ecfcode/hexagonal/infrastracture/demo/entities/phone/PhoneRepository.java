package com.ecfcode.hexagonal.infrastracture.demo.entities.phone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, PhoneID> {

}
