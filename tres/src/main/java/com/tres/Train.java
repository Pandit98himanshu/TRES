package com.tres;

import java.util.Map;

public class Train {
	
	int id;
	String name;
	// stores station-code as key and Halt object as value from source station
	Map<String, Halt> halts;
	
	public Train() {
		super();
	}

	public Train(int id, String name, Map<String, Halt> halts) {
		super();
		this.id = id;
		this.name = name;
		this.halts = halts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Halt> getHalts() {
		return halts;
	}

	public void setHalts(Map<String, Halt> halts) {
		this.halts = halts;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", name=" + name + ", halts=" + halts + "]";
	}

}
