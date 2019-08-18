package com.swissotel.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.swissotel.base.BaseClass;

public class SwPage03 extends BaseClass {
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_FooterButton_btnSubmit")
	WebElement step3contiunueButton;
	
	public SwPage03() throws IOException{
		PageFactory.initElements(driver, this); 
	}
	
	public void getPageTitle() {
		System.out.println("Page 3 Title : " + driver.getTitle());
	}

	public SwPage04 addExtraContinue() throws Exception{
		clickAction(step3contiunueButton);
//		step3contiunueButton.click();
		return new SwPage04();
		
	}
}
