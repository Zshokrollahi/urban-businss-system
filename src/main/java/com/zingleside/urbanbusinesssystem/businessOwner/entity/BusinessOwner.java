package com.zingleside.urbanbusinesssystem.businessOwner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class BusinessOwner {

    private Long id;

    private String name;

    private String lastName;

    private String nationalCode;

    private String phoneNumber;

}