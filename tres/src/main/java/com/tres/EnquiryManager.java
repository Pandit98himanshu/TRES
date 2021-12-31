package com.tres;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class EnquiryManager {

	private String source ;
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
	
	public boolean validateDate ( String d ) {
      try {
    		
    	  }
    	catch(DateTimeParseException dte)
    	{
    		
    	}
		return false;	
	}
	
	
}
