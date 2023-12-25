package com.zingleside.urbanbusinesssystem.advertising;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Advertising {
    @Id
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Long price;
}
