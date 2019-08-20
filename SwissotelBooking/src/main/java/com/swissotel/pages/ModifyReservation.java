package com.swissotel.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.swissotel.base.BaseClass;
import com.swissotel.base.ExcelData;
import com.swissotel.util.TestUtil;

public class ModifyReservation extends BaseClass {

	public ModifyReservation() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_ContentWithoutSideBar_ucChangeReservation_txtArrivalDate")
	WebElement arrivaldate;
	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_ContentWithoutSideBar_ucChangeReservation_txtDepartureDate")
	WebElement departuredate;
	@FindBy(how = How.LINK_TEXT, using = "SUBMIT CHANGES")
	WebElement submitchanges;

	public void getPageTitle() {
		System.out.println("Modify Reservation Page Title : " + driver.getTitle());
	}

	public void enterdata() throws Exception {
		ExcelData excel = new ExcelData();
		arrivaldate.clear();
		arrivaldate.sendKeys(excel.modifyfieldvalue(2));
		departuredate.clear();
		departuredate.sendKeys(excel.modifyfieldvalue(3));
	}

	public SwPage05 modify() throws Exception {
		clickAction(submitchanges);
//		submitchanges.click();
		return new SwPage05();
	}
}
