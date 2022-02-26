package com.tres.dao;

import com.tres.compositekey.CompositeKeySchedule;
import com.tres.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryScheduleRepo extends JpaRepository<Schedule, Integer> {
//    @Query(nativeQuery = true, value = "select * from schedule s where s.station_code=?1 and s.week_day=?2")
    public List<Schedule> findByStationCodeAndWeekDay(String stationCode, String weekDay);
}
