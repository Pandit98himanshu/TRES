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
    	/*try {
    		LocalDate date = LocalDate.parse(d);
    		LocalDate curr = LocalDate.now();
    		int diff = date.compareTo(curr);
    				if(diff<0 && diff>1){
    			       return false
    				}
    				

    	}
    	catch(DateTimeParseException dte)
    	{
    		
    	} */
		LocalDate date = LocalDate.parse("2023-10-31");
		//Date d =  new Date("2020-12-31");
    	LocalDate curr = LocalDate.now();
    	System.out.println(date);
    	System.out.println(curr);
    	System.out.println(date.compareTo(curr));
    	//System.out.println(date.compareTo(date));
		
		//return false;

    }
}
