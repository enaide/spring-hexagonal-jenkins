package com.ecfcode.hexagonal.infrastracture.repository.abstracts;

import com.ecfcode.hexagonal.infrastracture.entities.EmployeeTerritory;
import com.ecfcode.hexagonal.infrastracture.entities.EmployeeTerritoryId;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeTerritoryRepository extends CrudRepository<EmployeeTerritory, EmployeeTerritoryId> {
}
