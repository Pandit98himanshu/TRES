package com.tres.controller;

import com.tres.entity.result.Result;
import com.tres.exceptions.InvalidDateException;
import com.tres.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {

    @Autowired
    SearchService searchService;

    @GetMapping("/{src}/{dest}/{date}")
    public List<Result> getTrainsList(@PathVariable String src,
                                      @PathVariable String dest,
                                      @PathVariable String date) throws InvalidDateException {
        return searchService.searchTrains(src, dest, date);
    }
}
