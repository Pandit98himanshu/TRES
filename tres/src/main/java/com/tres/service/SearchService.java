package com.tres.service;

import com.tres.compositekey.CompositeKeyRoute;
import com.tres.dao.EnquiryRouteRepo;
import com.tres.dao.EnquiryScheduleRepo;
import com.tres.entity.Route;
import com.tres.entity.Schedule;
import com.tres.entity.result.Result;
import com.tres.exceptions.InvalidDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchService {

    @Autowired
    EntityManager entityManager;
    @Autowired
    EnquiryScheduleRepo enquiryScheduleRepo;
    @Autowired
    EnquiryRouteRepo enquiryRouteRepo;

    public String convertDateToWeekDay(String givenDate) throws InvalidDateException {
        Date date = null;
        try {
            date = Date.valueOf(givenDate);
        } catch (IllegalArgumentException ex) {
            throw new InvalidDateException("Invalid date: " + date + ". Please enter in the format yyyy-[m]m-[d]d.");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        return formatter.format(date).toLowerCase();
    }

    public List<Schedule> getTrainsDepFromSourceOnDay(String src, String day) {
        return enquiryScheduleRepo.findByStationCodeAndWeekDay(src, day);
    }

    public List<Route> getTrainsDepartsFromSrc(List<Schedule> srcTrainIds, String src) {
        List<Route> trainsDepFromSrc = new ArrayList<>();
        for (Schedule train : srcTrainIds) {
            trainsDepFromSrc.add(enquiryRouteRepo
                    .findByTrainIdAndStationCode(train.getTrainId(), src).get(0));
        }

        return trainsDepFromSrc;
    }

    public List<Route> getTrainsArrivesAtDest(List<Schedule> srcTrainIds, String dest) {
        List<Route> trainsArrAtDest = new ArrayList<>();
        for (Schedule train : srcTrainIds) {
            trainsArrAtDest.add(enquiryRouteRepo
                    .findByTrainIdAndStationCode(train.getTrainId(), dest).get(0));
        }
        return trainsArrAtDest;
    }

    public List<Result> searchTrains(String src, String dest, String date) throws InvalidDateException {

        // Converting date to week-day
        String day = convertDateToWeekDay(date);

/*
        String hql = "select * from schedule where station_code=:source_station and week_day=:day_of_travel";

        Query query = entityManager.createQuery(hql)
                .setParameter("source_station", src)
                .setParameter("day_of_travel", day);
        List<Schedule> result = query.getResultList();
*/


        // get list of all train ids which departs
        // from source station on that particular day
        List<Schedule> srcTrainIds = getTrainsDepFromSourceOnDay(src, day);

        // get all details of trains departs from source station
        List<Route> trainsDepFromSrc = getTrainsDepartsFromSrc(srcTrainIds, src);

        // get all details of trains arrives st destination station
        List<Route> trainsArrAtDest = getTrainsArrivesAtDest(srcTrainIds, dest);

        List<Result> resultList = new ArrayList<>();
        for (Route destTrain : trainsArrAtDest) {
            for (Route srcTrain : trainsDepFromSrc) {
                if (srcTrain.getTrainId() == destTrain.getTrainId()
                        && srcTrain.getHaltNo() < destTrain.getHaltNo()) {
                    resultList.add(new Result(srcTrain.getTrainId(), srcTrain.getDep(), destTrain.getArr()));
                }
            }
        }
        return resultList;
    }

}
