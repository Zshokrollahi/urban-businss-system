package com.zingleside.urbanbusinesssystem.business;

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
@Entity
public class Business {
    @Id
    @SequenceGenerator(
            name = "business_id_sequence",
            sequenceName = "business_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "business_id_sequence"
    )
    private Integer id ;
    @Column(nullable = false)
    private Integer registrationNumber ;
    @Column(nullable = false)
    private String name ;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return Objects.equals(id, business.id) && Objects.equals(registrationNumber, business.registrationNumber) && Objects.equals(name, business.name) && Objects.equals(phoneNumber, business.phoneNumber) && Objects.equals(description, business.description) && Objects.equals(address, business.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, registrationNumber, name, phoneNumber, description, address);
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", registrationNumber=" + registrationNumber +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", deescripton='" + description + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
