package com.swissotel.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.swissotel.base.BaseClass;

public class TestUtil extends BaseClass {
	
	
	public TestUtil() throws IOException {
		super();
	}

	public static long PAGE_LOAD_TIMEOUT = 120;
	public static long IMPLICIT_WAIT= 60;
	
	public static String arrivalDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, Integer.parseInt(prop.getProperty("ArrivaldateFromCurrentDate")));
		String date =dateFormat.format(c.getTime());
		return date;
	}

	public static String departureDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, Integer.parseInt(prop.getProperty("DepartureDateFromCurrentDate")));
		String date =dateFormat.format(c.getTime());
		return date;
	}
	
	public static String ModifyarrivalDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, (Integer.parseInt(prop.getProperty("ArrivaldateFromCurrentDate"))+7));
		String date =dateFormat.format(c.getTime());
		return date;
	}

	public static String ModifydepartureDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, (Integer.parseInt(prop.getProperty("DepartureDateFromCurrentDate"))+7));
		String date =dateFormat.format(c.getTime());
		return date;
	}
	
	public static String getScreenshot(WebDriver ldriver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("./Screenshots/" + getCurrentDateTime());
		String path = System.getProperty("user.dir") + "/Screenshots/SWUAT_" +getCurrentDateTime()+".png" ;
//		File destination = new File(path);
		FileHandler.copy(scr, new File(path));
		return path;
}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat =  new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
		
	}
	
	public static void screenshot() {
		if(browsername.equalsIgnoreCase("firefox")) {
	System.out.println("Screenshot method");
		} else {
//			System.out.println("Screenshot method");
		Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS, 2000, true).withName(TestUtil.getCurrentDateTime()).save("./Screenshots/");
		}
		}
	
	public static void verify(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}
}