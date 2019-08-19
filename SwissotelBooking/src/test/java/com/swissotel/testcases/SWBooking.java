package com.swissotel.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.swissotel.base.BaseClass;
import com.swissotel.pages.CancelReservation;
import com.swissotel.pages.ModifyReservation;
import com.swissotel.pages.ReservationDetails;
import com.swissotel.pages.SwPage01;
import com.swissotel.pages.SwPage02;
import com.swissotel.pages.SwPage03;
import com.swissotel.pages.SwPage04;
import com.swissotel.pages.SwPage05;
import com.swissotel.util.TestUtil;

public class SWBooking extends BaseClass {
//	WebDriver driver;
	SwPage01 page01;
	SwPage02 page02;
	SwPage03 page03;
	SwPage04 page04;
	SwPage05 page05;
	ReservationDetails reserdetails;
	ModifyReservation modifyRes;
	CancelReservation canRes;
	ExtentReports report;
	ExtentTest logger;

	public SWBooking() throws IOException {
		super();
	}

	@BeforeSuite
	public void setUpSuite() {
//		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir"+"/Report/SWUAT_"+TestUtil.getCurrentDateTime() + ".html")));
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./Report/demo02.html");
		report = new ExtentReports();
		report.attachReporter(extent);
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

	@Test(priority = 1, description = "Navigate to Step01")
	public void step1() throws Exception {
		logger = report.createTest("Step 01 ");
		String pageTitle = page01.validatePageTitle();
		logger.info("Navigated to Step1");
//		Assert.assertEquals(pageTitle, "- Swissôtel Hotels And Resorts");
		page01.enterdata();
		logger.pass("data entered in Step1 successfully");
		TestUtil.screenshot();
		page01.checkavailability();
	}

	@Test(priority = 2, description = "Navigate to Step02", dependsOnMethods = {"step1"})
	public void step2() throws Exception {
		logger = report.createTest("Step 02");
		page02.getPageTitle();
		page02.enterdata();
		TestUtil.screenshot();
		page02.selectRoomContinue();
	}

	@Test(priority = 3, description = "Navigate to Step03", dependsOnMethods = {"step2"})
	public void step3() throws Exception {
		logger = report.createTest("Step 03");
		TestUtil.screenshot();
		page03.getPageTitle();
		page03.addExtraContinue();
	}

	@Test(priority = 4, description = "Navigate to Step04", dependsOnMethods = {"step3"})
	public void step4() throws Exception {
		logger = report.createTest("Step 04");
		page04.getPageTitle();
		page04.enterdetails();
		TestUtil.screenshot();
		page04.submitdetails();
	}

	@Test(priority = 5, description = "Navigate to Step05", dependsOnMethods = {"step4"})
	public void step5() throws Exception {
		logger = report.createTest("Step 05");
		TestUtil.screenshot();
		page05.getPageTitle();
		page05.confirmNumber();
		page05.closeSurvey();
		page05.ModifyRes();
	}

	@Test(priority = 6, description = "Navigate to Reservation Details Page", dependsOnMethods = {"step5"})
	public void details() throws Exception {
		logger = report.createTest("Reservation Details");
		TestUtil.screenshot();
		reserdetails.getPageTitle();
		reserdetails.ModifyRes();
	}

	@Test(priority = 7, description = "Modify Reservation", dependsOnMethods = {"details"})
	public void modify() throws Exception {
		logger = report.createTest("Modify Reservation");
		modifyRes.getPageTitle();
		modifyRes.enterdata();
		TestUtil.screenshot();
		modifyRes.modify();
	}
	
	@Test(priority = 8, description = "Cancel Reservation", dependsOnMethods = {"modify"})
	public void cancel() throws Exception {
		logger = report.createTest("Cancel Reservation");
		TestUtil.screenshot();
		page05.ModifyRes();
		reserdetails.CancelRes();
		canRes.getPageTitle();
		canRes.cancelWindow();
		TestUtil.screenshot();
		System.out.println("Booking Cancelled successfully.");
//		canRes.CancelNumber();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail(result.getThrowable().getMessage());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("TC passed");
//					MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.getScreenshot(driver)).build());
		}
		report.flush();
	}

	@AfterClass
	public void closeApplication() throws Exception {
		Thread.sleep(5000);
		close();
		System.out.println("Browser Closed");
	}

}
