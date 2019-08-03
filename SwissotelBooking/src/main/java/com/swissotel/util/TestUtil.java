package com.swissotel.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestUtil {
	public static long PAGE_LOAD_TIMEOUT = 5;
	public static long IMPLICIT_WAIT= 5;
	
	public static String ArrivalDate(int NoOFDays){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, NoOFDays);
		String date =dateFormat.format(c.getTime());
		return date;
	}

}
