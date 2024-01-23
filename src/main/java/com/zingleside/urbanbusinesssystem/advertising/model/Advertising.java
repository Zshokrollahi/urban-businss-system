package com.zingleside.urbanbusinesssystem.advertising.model;


import java.math.BigDecimal;

public record Advertising(
        long id,
        String title,

        String description,

        BigDecimal price) {
}
