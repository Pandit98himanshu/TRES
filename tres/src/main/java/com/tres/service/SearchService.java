package com.tres.service;

import com.tres.entity.result.Result;

import java.util.List;

public interface SearchService {

    public List<Result> searchTrains(String src, String dest, String day);

}
