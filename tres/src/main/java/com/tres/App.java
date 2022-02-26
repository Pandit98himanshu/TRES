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

	public void func() {
//		System.out.println(search.convertDateToWeekDay("26-2-2022"));


	}
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Schedule> res = search.getTrainsDepFromSourceOnDay("SDAH", "thu");
		res.forEach(i -> System.out.println(i.getTrainId()));

		List<Route> resSrc = search.getTrainsDepartsFromSrc(res, "SDAH");
		System.out.println(resSrc);//resSrc.forEach(i -> System.out.println(i.getTrainId()));

		//		List<Result> res1 = search.searchTrains("SDAH", "PRNA", "24-2-2022");
	}
}
