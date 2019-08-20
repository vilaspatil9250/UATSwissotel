package com.swissotel.pages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.swissotel.base.BaseClass;

public class CancelReservation extends BaseClass {

	public CancelReservation() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.LINK_TEXT, using = "YES, CANCEL IT")
	WebElement cancellink;

	public void getPageTitle() {
		System.out.println("Cancel Reservation Page  Title : " + driver.getTitle());
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='ctl00_ctl00_cphMainContent_Content_lblCancellationNoValue']")
	WebElement cancelnum;
	
	@FindBy(how = How.ID, using = "ally_Close")
	WebElement allyBanner;
	
	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_PageTitle_lblConfirmation")
	WebElement pageLabel;
	

	public SwPage05 cancelWindow() throws Exception {
		String parentWinHandle = driver.getWindowHandle();
		Set<String> winHandles = driver.getWindowHandles();
		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
				String pagename = "Title of Cancel Window = " + driver.getTitle();
				System.out.println(pagename);
				cancellink.click();
			}
		}
		driver.switchTo().window(parentWinHandle);	
		return new SwPage05();
	}


	
	
}
