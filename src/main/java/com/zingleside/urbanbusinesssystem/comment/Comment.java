package com.zingleside.urbanbusinesssystem.comment;

import lombok.*;

import java.security.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Comment {
    private long id;
    private String description;
    private Timestamp uplaodTime;

}
