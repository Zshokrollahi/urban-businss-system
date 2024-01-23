package com.zingleside.urbanbusinesssystem.workinghours.model;

import java.time.LocalTime;

public record WorkingHour(
        Long id,
        LocalTime startTime,
        LocalTime endTime,
        Boolean fullTime,
        Boolean hollyDays

) {}


