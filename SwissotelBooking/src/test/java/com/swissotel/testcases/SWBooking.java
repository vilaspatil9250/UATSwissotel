package com.swissotel.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.swissotel.base.BaseClass;
import com.swissotel.pages.CancelReservation;
import com.swissotel.pages.ModifyReservation;
import com.swissotel.pages.ReservationDetails;
import com.swissotel.pages.SwPage01;
import com.swissotel.pages.SwPage02;
import com.swissotel.pages.SwPage03;
import com.swissotel.pages.SwPage04;
import com.swissotel.pages.SwPage05;

public class SWBooking extends BaseClass{
	WebDriver driver;
	SwPage01 page01;
	SwPage02 page02;
	SwPage03 page03;
	SwPage04 page04;
	SwPage05 page05;
	ReservationDetails reserdetails;
	ModifyReservation modifyRes;
	CancelReservation canRes;

	public SWBooking() throws IOException {
		super();
	}

	@BeforeClass
	public void startBrowser() throws Exception {
		initization();
		System.out.println("Browser Open");
		page01 = new SwPage01();
		page02 = new SwPage02();
		page03 = new SwPage03();
		page04 = new SwPage04();
		page05 = new SwPage05();
		reserdetails = new ReservationDetails();
		modifyRes = new ModifyReservation();
		canRes = new CancelReservation();
		
	}

	@Test(priority=1, description = "Navigate to Step01")
	public void step1() throws Exception {
		String pageTitle = page01.validatePageTitle();
		Assert.assertEquals(pageTitle, "- Swissôtel Hotels And Resorts");
		page01.checkavailability();
	}
	
	@Test(priority=2, description = "Navigate to Step02")
	public void step2() throws Exception {
		page02.getPageTitle();
		page02.selectRoomContinue();
	}
	
	@Test(priority=3, description = "Navigate to Step03")
	public void step3() throws Exception {
		page03.getPageTitle();
		page03.addExtraContinue();	
	}

	@Test(priority=4, description = "Navigate to Step04")
	public void step4() throws Exception {
		page04.getPageTitle();
		page04.enterdetails();	
	}
		
	@Test(priority=5, description = "Navigate to Step05")
	public void step5() throws Exception {
		page05.getPageTitle();
		page05.confirmNumber();
		page05.closeSurvey();
		page05.ModifyRes();
	}
	
	@Test(priority=6, description = "Navigate to Reservation Details Page")
	public void details() throws Exception {
		reserdetails.getPageTitle();
		reserdetails.ModifyRes();
	}
	
	@Test(priority=7, description = "Modify Reservation")
	public void modify() throws Exception {
		modifyRes.getPageTitle();
		modifyRes.modify();
	}
	
	
	@Test(priority=8, description = "Cancel Reservation")
	public void cancel() throws Exception {
		page05.ModifyRes();
		reserdetails.CancelRes();
		canRes.getPageTitle();
		canRes.cancelWindow();
		System.out.println("Booking Cancelled successfully.");
//		canRes.CancelNumber();
	}
	
	
	
	
	@AfterClass
	public void closeApplication() {
		close();
		System.out.println("Browser Closed");
		
	}

}
