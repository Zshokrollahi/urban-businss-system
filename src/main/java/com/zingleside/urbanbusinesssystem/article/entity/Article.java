package com.zingleside.urbanbusinesssystem.article.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Article {
    private Long id;
    private String title;
    private String type;
}
