package com.ecfcode.hexagonal.infrastructure.abstracts;

import com.ecfcode.hexagonal.infrastructure.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long>{

	Optional<Product> findById(Long id);
	Product findByProductName(String name);
	List<Product> findByCategory_CategoryId(int categoryId);
}
