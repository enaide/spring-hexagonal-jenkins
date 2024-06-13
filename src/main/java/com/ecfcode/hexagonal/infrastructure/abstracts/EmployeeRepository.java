package com.ecfcode.hexagonal.infrastructure.abstracts;

import com.ecfcode.hexagonal.infrastructure.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByReportsTo(Integer reportsTo);
	
	
	
}
