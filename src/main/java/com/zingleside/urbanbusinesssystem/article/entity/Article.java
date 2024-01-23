package com.zingleside.urbanbusinesssystem.article.entity;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record Article (

         Long id ,
         String title ,
         String description,
         String writer ,
         LocalDateTime createdAt
){

}
