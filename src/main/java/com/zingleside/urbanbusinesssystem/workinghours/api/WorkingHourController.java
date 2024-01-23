package com.zingleside.urbanbusinesssystem.workinghours.api;

import com.zingleside.urbanbusinesssystem.workinghours.DAO.WorkingHourJdbcAccessDAO;
import com.zingleside.urbanbusinesssystem.workinghours.model.WorkingHour;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "workingHour management")
public class WorkingHourController {
    private final WorkingHourJdbcAccessDAO workingHourJdbcAccessService;

    public WorkingHourController(WorkingHourJdbcAccessDAO workingHourJdbcAccessService) {
        this.workingHourJdbcAccessService = workingHourJdbcAccessService;
    }

    @GetMapping("/workingHour")
    List<WorkingHour> getAllWorkingHours (){
        return workingHourJdbcAccessService.selectALlWorkingHours();
    }

    @PostMapping("/workingHour")
    WorkingHour insertAdvertising(@RequestBody WorkingHour workingHour) {
        return workingHourJdbcAccessService.insertWorkingHour(workingHour);
    }

    @PutMapping("/workingHour")
    void update(@RequestBody WorkingHour workingHour, @PathVariable Long id ){
        workingHourJdbcAccessService.updateWorkingHourByID(id , workingHour);
        System.out.println("one field updated");
    }

}
