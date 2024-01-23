package com.zingleside.urbanbusinesssystem.workinghours.DAO;

import com.zingleside.urbanbusinesssystem.workinghours.model.WorkingHour;

import java.util.List;
import java.util.Optional;

public interface WorkingHourDAO {
    List<WorkingHour> selectALlWorkingHours();

    Optional<WorkingHour> selectAdvertisingBybusinessID(Long id);

    WorkingHour insertWorkingHour(WorkingHour workingHour);

    int deleteWorkingHourByID(Long id);
    void updateWorkingHourByID(Long id , WorkingHour workingHour);



}
