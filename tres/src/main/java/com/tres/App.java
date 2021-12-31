package com.tres;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
		LocalDate date = LocalDate.parse("2023-10-31");
		//Date d =  new Date("2020-12-31");
    	LocalDate curr = LocalDate.now();
    	
    	//System.out.println(date.compareTo(date));
    	String s = String.valueOf(curr.getDayOfWeek());
		System.out.println(s);
		//return false;
           
    }
}
