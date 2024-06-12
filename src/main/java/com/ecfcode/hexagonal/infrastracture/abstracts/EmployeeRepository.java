package com.ecfcode.hexagonal.infrastracture.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByReportsTo(Integer reportsTo);
	
	
	
}
