package com.tres;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
/**
 * Hello world!
 *
 */
public class App 
{
	public static Date addHoursToJavaUtilDate(Date date, int hours) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, hours);
	    return (Date) calendar.getTime();
	}
	
    public static void main( String[] args )
    {
    	
		LocalDate date = LocalDate.parse("2023-10-31");
		//Date d =  new Date("2020-12-31");
    	LocalDateTime curr = LocalDateTime.now();
    	
    	String s = String.valueOf(curr.getDayOfWeek());
//		System.out.println(s);
		
		System.out.println(curr.plusMinutes(1810));
		
//    	System.out.println(addHoursToJavaUtilDate(6));
    }
}
