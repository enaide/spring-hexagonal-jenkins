package com.ecfcode.hexagonal.infrastructure.abstracts;

import com.ecfcode.hexagonal.infrastructure.entities.concretes.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
