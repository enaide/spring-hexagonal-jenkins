package com.ecfcode.hexagonal.infrastracture.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeTerritoryId implements Serializable {

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "territory_id")
    private String territoryId;

    public EmployeeTerritoryId() {}

    public EmployeeTerritoryId(Integer employeeId, String territoryId) {
        this.employeeId = employeeId;
        this.territoryId = territoryId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeTerritoryId that = (EmployeeTerritoryId) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(territoryId, that.territoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, territoryId);
    }

    @Override
    public String toString() {
        return "EmployeeTerritoryId{" +
                "employeeId=" + employeeId +
                ", territoryId='" + territoryId + '\'' +
                '}';
    }
}
