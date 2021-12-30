package com.tres;

import java.util.Date;

public class Halt {
	
	private int number;
	private Date arrTime;
	private Date depTime;
	private int durationFromSrc;
	
	
	public Halt() {
		super();
	}

	public Halt(int number, Date arrTime, Date depTime, int durationFromSrc) {
		super();
		this.number = number;
		this.arrTime = arrTime;
		this.depTime = depTime;
		this.durationFromSrc = durationFromSrc;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getArrTime() {
		return arrTime;
	}

	public void setArrTime(Date arrTime) {
		this.arrTime = arrTime;
	}

	public Date getDepTime() {
		return depTime;
	}

	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}

	public int getDurationFromSrc() {
		return durationFromSrc;
	}

	public void setDurationFromSrc(int durationFromSrc) {
		this.durationFromSrc = durationFromSrc;
	}
	
	
}
