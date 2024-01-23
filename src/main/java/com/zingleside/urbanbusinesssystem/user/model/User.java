package com.zingleside.urbanbusinesssystem.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record User (
     Long id ,
    String username ,
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
     String password,
     String name,
     String lastName,
     Long phoneNumber){

}
