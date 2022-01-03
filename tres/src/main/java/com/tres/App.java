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
		
		
		
		Map<String, List<Train>> trains2 = new HashMap<>();
		List<Train> list2 = new ArrayList<>();
		Map<String, Halt> halts2 = new HashMap<>();
		
		Map<String, Station> map2 = new HashMap<String, Station>();
		LocalDateTime arr2, dep2;

		arr2 = LocalDateTime.parse("2022-02-03T06:35:10");
		dep2 = LocalDateTime.parse("2022-02-03T06:37:10");
		duration = 35;
		halt1 = new Halt(0, arr2, dep2, duration);
		halts2.put("LTT", halt1);

		arr2 = LocalDateTime.parse("2022-02-03T07:00:00");
		dep2 = LocalDateTime.parse("2022-02-03T07:02:00");
		duration = 20;
		halt1 = new Halt(1, arr2, dep2, duration);
		halts2.put("JL", halt1);

		arr2 = LocalDateTime.parse("2022-02-03T11:35:10");
		dep2 = LocalDateTime.parse("2022-02-03T11:37:10");
		duration = 50;
		halt1 = new Halt(2, arr2, dep2, duration);
		halts2.put("TLV", halt1);

		arr2 = LocalDateTime.parse("2022-02-03T21:00:00");
		dep2 = LocalDateTime.parse("2022-02-03T21:02:00");
		duration = 130;
		halt1 = new Halt(3, arr2, dep2, duration);
		halts2.put("ET", halt1);

		list2.add(new Train(15017, "KASHI EXP", halts2));
		trains2.put("THURSDAY", list2);

		Station st1 = new Station("LTT", "LOKMANYATILAK", trains2);
		Station st2 = new Station("JL", "THANE", trains2);
		map2.put("LTT", st1);
		map2.put("JL", st2);
		map2.put("TLV", new Station("TLV", "TALVADYA", trains2));
		map2.put("ET", new Station("ET", "ITARSI JN", trains2));

		stnMgr1 = new StationManager(map2);
		
		
		
		Map<String, List<Train>> trains3 = new HashMap<>();
		List<Train> list3 = new ArrayList<>();
		Map<String, Halt> halts3 = new HashMap<>();
		
		Map<String, Station> map3 = new HashMap<String, Station>();
		LocalDateTime arr3, dep3;

		arr3 = LocalDateTime.parse("2022-02-03T11:35:10");
		dep3 = LocalDateTime.parse("2022-02-03T11:37:10");
		duration = 35;
		halt1 = new Halt(0, arr3, dep3, duration);
		halts3.put("LTT", halt1);

		arr3 = LocalDateTime.parse("2022-02-03T12:00:00");
		dep3 = LocalDateTime.parse("2022-02-03T12:02:00");
		duration = 20;
		halt1 = new Halt(1, arr3, dep3, duration);
		halts3.put("JL", halt1);

		arr3 = LocalDateTime.parse("2022-02-03T16:35:10");
		dep3 = LocalDateTime.parse("2022-02-03T16:37:10");
		duration = 50;
		halt1 = new Halt(2, arr3, dep3, duration);
		halts3.put("TLV", halt1);

		arr3 = LocalDateTime.parse("2022-02-03T21:00:00");
		dep3 = LocalDateTime.parse("2022-02-03T21:02:00");
		duration = 130;
		halt1 = new Halt(3, arr3, dep3, duration);
		halts3.put("ET", halt1);

		Train tr = new Train(13578, "ROYAL EXP", halts3);
		List<Train> list_New = stnMgr1.getMap().get("LTT").getTrainsOnDay().get("THURSDAY");
		list_New.add(tr);
		
		list_New = stnMgr1.getMap().get("JL").getTrainsOnDay().get("THURSDAY");
		list_New.add(tr);
		
		list_New = stnMgr1.getMap().get("TLV").getTrainsOnDay().get("THURSDAY");
		list_New.add(tr);
		
		list_New = stnMgr1.getMap().get("ET").getTrainsOnDay().get("THURSDAY");
		list_New.add(tr);
		
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
