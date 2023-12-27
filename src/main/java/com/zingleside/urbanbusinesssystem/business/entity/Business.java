package com.zingleside.urbanbusinesssystem.business.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Business {

    private Long id ;

    private String name ;

    private String phoneNumber;

    private String description;

    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return Objects.equals(id, business.id) && Objects.equals(name, business.name) && Objects.equals(phoneNumber, business.phoneNumber) && Objects.equals(description, business.description) && Objects.equals(address, business.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, description, address);
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deescripton='" + description + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
