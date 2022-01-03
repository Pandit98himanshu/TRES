package com.tres;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

	public boolean isValidStation(String stn, StationManager stnMgr) {
		Map<String, Station> map = stnMgr.getMap();
		if (map.containsKey(stn))
			return true;

		return false;
	}

	/**
	 * Converts {@link Date} to week-day
	 * 
	 * @param s
	 * @return
	 */
	public String dateToDay(String s) {
		if (isValidDate(s)) {
			LocalDate d = LocalDate.parse(s);

			return String.valueOf(d.getDayOfWeek());
		}
		return null;
	}

	public LocalDateTime getArrivalDate(LocalDateTime srcDepartureTime, int minutes) {
		return srcDepartureTime.plusMinutes(minutes);
	}

	public Map<Train, LocalDateTime> searchTrains(String src, String dest, String date, StationManager stnMgr) {
		if (!isValidDate(date)) {
			System.out.println("Invalid date of journey.");
			return null;
		}
		if (!isValidStation(src, stnMgr)) {
			System.out.println("Invalid source station.");
			return null;
		}
		if (!isValidStation(dest, stnMgr)) {
			System.out.println("Invalid destination station.");
			return null;
		}

		// convert date of journey to week-day
		String day = dateToDay(date);

		Map<Train, LocalDateTime> searchResults = new HashMap<>();

		// get trains leaving source station
		Station station = stnMgr.getMap().get(src);

		List<Train> trains = station.getTrainsOnDay().get(day);

		// iterate all the trains and search destination as a halt
		for (Train train : trains) {
			
			if (train.getHalts().containsKey(dest)) {
				Halt srcHalt = train.getHalts().get(src);
				Halt destHalt = train.getHalts().get(dest);
				
				// destination station must come later the source station 
				if (srcHalt.getNumber() < destHalt.getNumber()) {
					LocalDateTime depTimeFromSrc = srcHalt.getDepTime();

					// duration to travel from source to destination station (for user) 
					long duration = destHalt.getDurationFromSrc() - srcHalt.getDurationFromSrc();
					
					// get arrival time of the train at destination
					LocalDateTime arrTimeAtDest = depTimeFromSrc.plusMinutes(duration);
					
					// add to result
					searchResults.put(train, arrTimeAtDest);
				}
			}
		}

		return searchResults;
	}
}
