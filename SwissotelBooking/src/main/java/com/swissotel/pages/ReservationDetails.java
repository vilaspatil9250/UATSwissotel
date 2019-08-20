package com.swissotel.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.swissotel.base.BaseClass;

public class ReservationDetails extends BaseClass {
	public String  expectedpagename = "YOUR RESERVATION"; 

	public ReservationDetails() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_PageTitle_lblYourReservation")
	WebElement pagename;
	
	@FindBy(how = How.LINK_TEXT, using = "MODIFY RESERVATION")
	WebElement modres;
	
	@FindBy(how = How.LINK_TEXT, using = "CANCEL RESERVATION")
	WebElement cancelres;
	
	public String actualpagename() {
		return pagename.getText();
	}
	
	public void getPageTitle() {
		System.out.println("Reservation Details Page Title : " + driver.getTitle());
	}

	public ModifyReservation ModifyRes() throws Exception {
		clickAction(modres);
//		modres.click();
		return new ModifyReservation();
	}

	public CancelReservation CancelRes() throws Exception {
		clickAction(cancelres);
//		cancelres.click();
		return new CancelReservation();
	}
	

}
