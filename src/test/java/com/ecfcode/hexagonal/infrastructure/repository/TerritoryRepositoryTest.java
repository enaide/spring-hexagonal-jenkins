package com.ecfcode.hexagonal.infrastructure.repository;

import com.ecfcode.hexagonal.infrastructure.usecase.EmployeeTerritory;
import com.ecfcode.hexagonal.infrastructure.usecase.EmployeeTerritoryId;
import com.ecfcode.hexagonal.infrastructure.usecase.abstracts.EmployeeRepository;
import com.ecfcode.hexagonal.infrastructure.usecase.abstracts.EmployeeTerritoryRepository;
import com.ecfcode.hexagonal.infrastructure.usecase.abstracts.TerritoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class TerritoryRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    TerritoryRepository territoryRepository;
    @Autowired
    EmployeeTerritoryRepository employeeTerritoryRepository;

    @Test
    void findById() {
        EmployeeTerritoryId id = new EmployeeTerritoryId(1, "06897");
        Optional<EmployeeTerritory> employeeTerritoryOptional = employeeTerritoryRepository.findById(id);
        assertTrue(employeeTerritoryOptional.isPresent());
        System.out.println(employeeTerritoryOptional.get().getEmployee());
    }
}