package com.tres;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class App {
	
	public static void main(String[] args) {

		Map<String, List<Train>> trains1 = new HashMap<>();
		List<Train> list1 = new ArrayList<>();
		Map<String, Halt> halts1 = new HashMap<>();
		Halt halt1;
		Map<String, Station> map1 = new HashMap<String, Station>();
		LocalDateTime arr1, dep1;
		int duration;
		
		arr1 = LocalDateTime.parse("2021-12-31T16:03:10.446042");
		dep1 = LocalDateTime.parse("2021-12-31T16:03:10.446042");
		duration = 40;
		halt1 = new Halt(0, arr1, dep1, duration);
		halts1.put("HWH", halt1);
		
		arr1 = LocalDateTime.parse("2021-12-31T16:43:10.446042");
		dep1 = LocalDateTime.parse("2021-12-31T16:45:10.446042");
		duration = 65;
		halt1 = new Halt(1, arr1, dep1, duration);
		halts1.put("BDC", halt1);
		
		arr1 = LocalDateTime.parse("2021-12-31T17:07:10.446042");
		dep1 = LocalDateTime.parse("2021-12-31T17:10:10.446042");
		duration = 95;
		halt1 = new Halt(2, arr1, dep1, duration);
		halts1.put("MLDT", halt1);
		
		
		list1.add(new Train(13465, "INTERCITY EXP", halts1));
		trains1.put("FRIDAY", list1);
		
		map1.put("HWH", new Station("HWH", "Howrah Jn", trains1));
		map1.put("BDC", new Station("BDC", "BANDEL JN", trains1));
		map1.put("MLDT", new Station("MLDT", "Malda Town", trains1));
		
		StationManager stnMgr1 = new StationManager(map1);
		
		
		/*
		LocalDateTime date = LocalDateTime.parse("16:36");
		// Date d = new Date("2020-12-31");
		LocalDateTime curr = LocalDateTime.now();

		String s = String.valueOf(curr.getDayOfWeek());
//		System.out.println(s);

		System.out.println(curr.plusMinutes(1810));
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Src:");
		String src = sc.nextLine().trim();
		System.out.print("Dest:");
		String dest = sc.nextLine().trim();
		System.out.print("Date:");
		String date = sc.nextLine().trim();
		
		EnquiryManager enqMgr = new EnquiryManager();
		Map<Train, LocalDateTime> results = enqMgr.searchTrains(src, dest, date, stnMgr1);
		
		for (Map.Entry<Train, LocalDateTime> entry : results.entrySet()) {
	        System.out.println(entry.getKey().getId() + " | " + entry.getKey().getName() + " | " + entry.getValue());
	    }
		
	}
}
