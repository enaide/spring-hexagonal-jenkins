package com.ecfcode.hexagonal.infrastructure.abstracts;

import com.ecfcode.hexagonal.infrastructure.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Product findById(int id);
	Product findByProductName(String name);
	List<Product> findByCategory_CategoryId(int categoryId);
}
