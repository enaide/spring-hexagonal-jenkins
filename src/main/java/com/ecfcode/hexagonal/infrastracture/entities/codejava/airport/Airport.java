package com.ecfcode.hexagonal.infrastracture.entities.codejava.airport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "airports")
@IdClass(AirportID.class)
public class Airport {
    @Id
    @Column(length = 3)
    private String countryCode;

    @Id @Column(length = 3)
    private String cityCode;

    @Column(length = 50, nullable = false)
    private String name;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(countryCode, airport.countryCode) && Objects.equals(cityCode, airport.cityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, cityCode);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "cityCode='" + cityCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
