package com.swissotel.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.swissotel.base.BaseClass;
import com.swissotel.base.ExcelData;
import com.swissotel.util.TestUtil;

public class SwPage01 extends BaseClass {
	
	@FindBy(how = How.ID, using = "ally_Close")
	WebElement allybanner;
	

	@FindBy(how = How.ID, using = "ddlDestination")
	WebElement destination;

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_Content_txtArrivalDate")
	WebElement arrivalDate;

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_Content_txtDepartureDate")
	WebElement departuredate;

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_FooterButton_btnCheckAvailability")
	WebElement checkAvailability;

	public SwPage01() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public void enterdata() throws Exception {
		//allybanner.click();
		ExcelData excel = new ExcelData();
		Select destinationlist = new Select(destination);
		destinationlist.selectByVisibleText(excel.fieldvalue(1));
		arrivalDate.clear();
//		arrivalDate.sendKeys(TestUtil.arrivalDate());
		arrivalDate.sendKeys(excel.fieldvalue(2));
		departuredate.clear();
//		departuredate.sendKeys(TestUtil.departureDate());
		departuredate.sendKeys(excel.fieldvalue(3));
	}
	
	public SwPage02 checkavailability() throws IOException {
		clickAction(checkAvailability);
//		checkAvailability.click();
		return new SwPage02();

	}

}
