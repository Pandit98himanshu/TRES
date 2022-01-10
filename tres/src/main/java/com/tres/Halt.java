package com.tres;

import java.time.LocalDateTime;

public class Halt {
	
	private int number;
	private LocalDateTime arrTime;
	private LocalDateTime depTime;
	private int durationFromSrc;
	
	
	public Halt() {
		super();
	}

	public Halt(int number, LocalDateTime arrTime, LocalDateTime depTime, int durationFromSrc) {
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

	public LocalDateTime getArrTime() {
		return arrTime;
	}

	public void setArrTime(LocalDateTime arrTime) {
		this.arrTime = arrTime;
	}

	public LocalDateTime getDepTime() {
		return depTime;
	}

	public void setDepTime(LocalDateTime depTime) {
		this.depTime = depTime;
	}

	public int getDurationFromSrc() {
		return durationFromSrc;
	}

	public void setDurationFromSrc(int durationFromSrc) {
		this.durationFromSrc = durationFromSrc;
	}

	@Override
	public String toString() {
		return "Halt [number=" + number + ", arrTime=" + arrTime + ", depTime=" + depTime + ", durationFromSrc="
				+ durationFromSrc + "]";
	}
	
	
}
