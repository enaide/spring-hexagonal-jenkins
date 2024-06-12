package com.ecfcode.hexagonal.infrastracture.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

}
