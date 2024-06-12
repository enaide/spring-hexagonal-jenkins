package com.ecfcode.hexagonal.infrastracture.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{

	Category findById(int id);
	Category findByCategoryName(String name);
}
