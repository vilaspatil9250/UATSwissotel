package com.swissotel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.swissotel.base.BaseClass;

public class SwPage05 extends BaseClass{

	public SwPage05() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_lblConfirmationNosValue")
	WebElement confirmnum;
	
	
	public void getPageTitle() {
		System.out.println("Page 5 Title : " + driver.getTitle());
	}
	
	public void confirmNumber() {
		String ConfirmationNumber = confirmnum.getText();
		System.out.println("Booking Confirmation Number = " + ConfirmationNumber);
	}
	
}
