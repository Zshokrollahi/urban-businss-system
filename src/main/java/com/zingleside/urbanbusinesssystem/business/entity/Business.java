package com.zingleside.urbanbusinesssystem.business.entity;

public record Business(
    Long id,
    String name,
    String phoneNumber,
    String description,
    String address,
    long businessOwnerId) {}
