package com.tres;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Map;

public class EnquiryManager {

	private String source;
	private String destination;
	private String date;
	private String day;

	public EnquiryManager() {
		super();
	}

	public EnquiryManager(String source, String destination, String date, String day) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.day = day;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public boolean isValidDate(String d) {

		try {

			LocalDate date = LocalDate.parse(d);
			LocalDate curr = LocalDate.now();
			int diff = date.compareTo(curr);
			int year = date.getYear();
			int curr_year = curr.getYear();
			if (diff >= 0 && (year - curr_year) <= 1)
				return true;
		} catch (DateTimeParseException dte) {
			System.out.println("Invalid Date entered");
			dte.printStackTrace();
		}
		return false;
	}

	public boolean isValidStation(String stn) {
		StationManager sm = new StationManager();
		Map<String, Station> map = sm.getMap();
		if (map.containsKey(stn))
			return true;

		return false;
	}
	
	public String dateToDay(String s)
	{
		if(isValidDate(s))
		{
			LocalDate d = LocalDate.parse(s);
			
			return String.valueOf(d.getDayOfWeek());
		}
		return null;
	}
	

}
