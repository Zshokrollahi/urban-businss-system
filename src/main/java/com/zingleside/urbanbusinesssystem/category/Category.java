package com.zingleside.urbanbusinesssystem.category;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Category {
    private Long id;
    private String userName;
    private String name;
    private String lastName;
}
