package com.ecfcode.hexagonal.infrastracture.demo.entities.airport;

import java.io.Serializable;
import java.util.Objects;

public class AirportID implements Serializable {
    private String countryCode;
    private String cityCode;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirportID airportID = (AirportID) o;
        return Objects.equals(countryCode, airportID.countryCode) && Objects.equals(cityCode, airportID.cityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, cityCode);
    }
}
