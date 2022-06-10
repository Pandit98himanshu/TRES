package com.tres.service;

import com.tres.dao.EnquiryRouteRepo;
import com.tres.dao.EnquiryScheduleRepo;
import com.tres.dao.EnquiryStationRepo;
import com.tres.dao.EnquiryTrainRepo;
import com.tres.entity.Route;
import com.tres.entity.Schedule;
import com.tres.entity.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    @Autowired
    EntityManager entityManager;
    @Autowired
    EnquiryScheduleRepo enquiryScheduleRepo;
    @Autowired
    EnquiryRouteRepo enquiryRouteRepo;
    @Autowired
    EnquiryTrainRepo enquiryTrainRepo;
    @Autowired
    EnquiryStationRepo enquiryStationRepo;

    private List<Schedule> getTrainsDepFromSourceOnDay(String src, String day) {
        return enquiryScheduleRepo.findByStationCodeAndWeekDay(src, day);
    }

    private List<Route> getTrainsDepartsFromSrc(List<Schedule> srcTrainIds, String src) {
        List<Route> trainsDepFromSrc = new ArrayList<>();
        for (Schedule train : srcTrainIds) {
            trainsDepFromSrc.add(enquiryRouteRepo
                    .findByTrainIdAndStationCode(train.getTrainId(), src).get(0));
        }

        return trainsDepFromSrc;
    }

    private List<Route> getTrainsArrivesAtDest(List<Schedule> srcTrainIds, String dest) {
        List<Route> trainsArrAtDest = new ArrayList<>();
        for (Schedule train : srcTrainIds) {
            trainsArrAtDest.add(enquiryRouteRepo
                    .findByTrainIdAndStationCode(train.getTrainId(), dest).get(0));
        }
        return trainsArrAtDest;
    }

    public List<Result> searchTrains(String src, String dest, String day) {

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

                    resultList.add(new Result(srcTrain.getTrainId(),
                            enquiryTrainRepo.getById(srcTrain.getTrainId()).getName(),
                            enquiryStationRepo.getById(srcTrain.getStationCode()).getName(),
                            srcTrain.getDep(),
                            enquiryStationRepo.getById(destTrain.getStationCode()).getName(),
                            destTrain.getArr(),
                            destTrain.getDay() - srcTrain.getDay()));
                }
            }
        }
        return resultList;
    }

}
