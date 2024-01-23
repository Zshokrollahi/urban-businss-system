package com.zingleside.urbanbusinesssystem.comment.model;


import java.security.Timestamp;

public record Comment(
         long id,
         String description ,
        Timestamp uploadedDate

) {

}
