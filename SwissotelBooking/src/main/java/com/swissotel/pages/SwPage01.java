package com.swissotel.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.swissotel.base.BaseClass;
import com.swissotel.util.TestUtil;

public class SwPage01 extends BaseClass {
	

	@FindBy(how = How.ID, using = "ddlDestination")
	WebElement destination;
	

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_Content_txtArrivalDate")
	WebElement arrivalDate;

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_Content_txtDepartureDate")
	WebElement departuredate;

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_FooterButton_btnCheckAvailability")
	WebElement checkAvailability;
	
	public SwPage01()throws IOException{
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public SwPage02 checkavailability() throws IOException{
		Select destinationlist = new Select(destination);
		destinationlist.selectByVisibleText("Zurich, Switzerland");
		arrivalDate.clear();
		arrivalDate.sendKeys(TestUtil.ArrivalDate(30));
		departuredate.clear();
		departuredate.sendKeys(TestUtil.ArrivalDate(31));
		checkAvailability.click();
		return new SwPage02();
	
	}


}
