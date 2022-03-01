package com.tres;

import com.tres.dao.EnquiryScheduleRepo;
import com.tres.entity.Route;
import com.tres.entity.Schedule;
import com.tres.entity.result.Result;
import com.tres.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	SearchService search;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Schedule> res = search.getTrainsDepFromSourceOnDay("SDAH", "thu");
		res.forEach(System.out::println);

		System.out.println("=============Src============");
		List<Route> resSrc = search.getTrainsDepartsFromSrc(res, "SDAH");
		resSrc.forEach(System.out::println);
		System.out.println("=============Dest============");
		List<Route> resDest = search.getTrainsArrivesAtDest(res, "PRNA");
		resDest.forEach(System.out::println);

		System.out.println("=============Ans============");
		List<Result> res1 = search.searchTrains("SDAH", "PRNA", "2022-2-24");
		res1.forEach(System.out::println);
	}
}
