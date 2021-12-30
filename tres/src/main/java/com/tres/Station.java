package com.tres;

import java.util.Map;

public class Station {
	
	private String code;
	private String name;
	// stores week-days as key and Train object as value which runs on that particular day
	private Map<String, Train> trainsOnDay;
	
	public Station() {
		super();
	}

	public Station(String code, String name, Map<String, Train> trainsOnDay) {
		super();
		this.code = code;
		this.name = name;
		this.trainsOnDay = trainsOnDay;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Train> getTrainsOnDay() {
		return trainsOnDay;
	}

	public void setTrainsOnDay(Map<String, Train> trainsOnDay) {
		this.trainsOnDay = trainsOnDay;
	}
	
}
