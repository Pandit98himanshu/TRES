package com.tres.service;

import com.tres.dao.EnquiryRepoRoute;
import com.tres.dao.EnquiryRepoSchedule;
import com.tres.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SearchService {

    @Autowired
    EntityManager entityManager;
    @Autowired
    EnquiryRepoSchedule enquiryRepoSchedule;
    @Autowired
    EnquiryRepoRoute enquiryRepoRoute;

    public void searchTrains(String src, String dest, String day) {
/*
        String hql = "select * from schedule where station_code=:source_station and :day_of_travel=true";

        Query query = entityManager.createQuery(hql)
                .setParameter("source_station", src)
                .setParameter("day_of_travel", day);
        List<Schedule> result = query.getResultList();
*/

    }
}
