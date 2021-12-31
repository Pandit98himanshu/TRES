package com.tres;

import java.util.Map;

public class StationManager {
	Map<String, Station> map;

	public StationManager() {
		super();
	}

	public StationManager(Map<String, Station> map) {
		super();
		this.map = map;
	}

	public Map<String, Station> getMap() {
		return map;
	}

	public void setMap(Map<String, Station> map) {
		this.map = map;
	}

}
