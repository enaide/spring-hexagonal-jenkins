package com.ecfcode.hexagonal.infrastracture.usecase.abstracts;


import com.ecfcode.hexagonal.infrastracture.usecase.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
