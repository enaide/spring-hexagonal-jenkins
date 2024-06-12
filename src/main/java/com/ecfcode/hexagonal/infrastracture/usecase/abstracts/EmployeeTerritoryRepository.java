package com.ecfcode.hexagonal.infrastracture.usecase.abstracts;

import com.ecfcode.hexagonal.infrastracture.usecase.EmployeeTerritory;
import com.ecfcode.hexagonal.infrastracture.usecase.EmployeeTerritoryId;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeTerritoryRepository extends CrudRepository<EmployeeTerritory, EmployeeTerritoryId> {
}
