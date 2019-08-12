package com.swissotel.pages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.swissotel.base.BaseClass;

public class SwPage05 extends BaseClass {

	public SwPage05() throws Exception {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_Content_lblConfirmationNosValue")
	WebElement confirmnum;

	@FindBy(how = How.LINK_TEXT, using="Modify Reservation")
	WebElement modifyreservation;
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_ctl00_cphMainContent_Content_lblCancellationNoValue']")
	WebElement cancelnum;
	
	public void getPageTitle() {
		System.out.println("Page 5 Title : " + driver.getTitle());
	}

	public void confirmNumber() {
		String ConfirmationNumber = confirmnum.getText();
		System.out.println("Booking Confirmation Number = " + ConfirmationNumber);
	}
	
	public void CancelNumber() {
		String parentWinHandle = driver.getWindowHandle();
		driver.switchTo().window(parentWinHandle);
		String CancellationNumber = cancelnum.getText();
		System.out.println("Booking Cancellation Number = " + CancellationNumber);
	}

	public void closeSurvey() {
		String parentWinHandle = driver.getWindowHandle();

		Set<String> winHandles = driver.getWindowHandles();

		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
				String pagename = "Title of Survey Window = " + driver.getTitle();
				System.out.println(pagename);
				driver.close();
				driver.switchTo().window(parentWinHandle);
			}
		}
	}

	public ReservationDetails ModifyRes() throws Exception {
		modifyreservation.click();
		return new ReservationDetails();
	}
	
	
	
	
}
