package com.ecfcode.hexagonal.infrastracture.repository;


import com.ecfcode.hexagonal.infrastracture.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
