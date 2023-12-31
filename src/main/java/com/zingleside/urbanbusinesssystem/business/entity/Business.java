package com.zingleside.urbanbusinesssystem.business.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;


public record Business (

         Long id,

        String name,

        String phoneNumber ,

        String description ,

        String address


){}