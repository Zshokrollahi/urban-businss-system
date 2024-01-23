package com.zingleside.urbanbusinesssystem.workinghours.DAO;

import com.zingleside.urbanbusinesssystem.workinghours.model.WorkingHour;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class WorkingHourJdbcAccessDAO implements WorkingHourDAO{
    private final JdbcClient jdbcClient;

    public WorkingHourJdbcAccessDAO(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<WorkingHour> selectALlWorkingHours() {
        return jdbcClient.sql("select * from working_hours").query(WorkingHour.class).list();
    }

    @Override
    public Optional<WorkingHour> selectAdvertisingBybusinessID(Long id) {
        return Optional.empty();
    }

    @Override
    public WorkingHour insertWorkingHour(WorkingHour workingHour) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcClient.sql("insert into working_hours(start_time, end_time, holy_days, full_time, business_id) values (:startTime ,:endTime ,:hollyDays , :fullTime, :business_id)")
                .paramSource(workingHour).update(keyHolder);
        Long id = (Long) keyHolder.getKeys().get("id");
        return jdbcClient.sql("select id, start_time, end_time, holy_days, full_time, business_id from working_hours where id = :id")
                .param("id", id)
                .query(WorkingHour.class).single();

    }

    @Override
    public int deleteWorkingHourByID(Long id) {
       return 0;
    }

    @Override
    public void updateWorkingHourByID(Long id,WorkingHour workingHour) {
         jdbcClient.sql("update working_hours" +
                " set holy_days = ? where id = ?").paramSource(WorkingHour.class).update();

    }
}



