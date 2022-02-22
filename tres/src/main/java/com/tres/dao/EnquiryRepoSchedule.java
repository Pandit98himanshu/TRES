package com.tres.dao;

import com.tres.compositekey.CompositeKeySchedule;
import com.tres.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryRepoSchedule extends JpaRepository<Schedule, CompositeKeySchedule> {
    public List<Schedule> findByStationCodeAndWeekDay(String stationCode, String weekDay);
}
