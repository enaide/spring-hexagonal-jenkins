package com.ecfcode.hexagonal.infrastracture.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.concretes.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
