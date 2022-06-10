package com.tres.controller;

import com.tres.entity.result.Result;
import com.tres.exceptions.InvalidDateException;
import com.tres.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    SearchService searchService;

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

    @GetMapping("/{src}/{dest}/{date}")
    public List<Result> getTrainsList(@PathVariable String src,
                                      @PathVariable String dest,
                                      @PathVariable String date) throws InvalidDateException {
        String day = convertDateToWeekDay(date);
        return searchService.searchTrains(src, dest, day);
    }
}
