package com.ecfcode.hexagonal.infrastructure.demo.entities.phone;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PhoneID implements Serializable {

    @Column(name = "area_code")
    private int areaCode;

    @Column(length = 15)
    private String number;

    public PhoneID() {
    }

    public PhoneID(int areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneID phoneID = (PhoneID) o;
        return areaCode == phoneID.areaCode && Objects.equals(number, phoneID.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }

    @Override
    public String toString() {
        return "PhoneID{" +
                "areaCode=" + areaCode +
                ", number='" + number + '\'' +
                '}';
    }
}
