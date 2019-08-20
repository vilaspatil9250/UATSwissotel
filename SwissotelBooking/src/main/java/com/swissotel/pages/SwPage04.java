package com.swissotel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.swissotel.base.BaseClass;
import com.swissotel.base.ExcelData;

public class SwPage04 extends BaseClass {
	public String  expectedpagename = "INFO & PAYMENT"; 
	
	public SwPage04() throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_PageTitle_ucReservationTitle_lblTitle")
	WebElement pagename;

	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_ddlTitle")
	WebElement title;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtFirstName")
	WebElement firstname;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtLastName")
	WebElement lastname;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_ddlPhonePrefix")
	WebElement prefix;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtTelephone")
	WebElement telephone;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtEmailAddress")
	WebElement email;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtAddressLine1")
	WebElement addresslineone;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_ddlCountry")
	WebElement country;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtCity")
	WebElement city;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtPostalCode")
	WebElement zipcode;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_ddlCreditCardType")
	WebElement cardtype;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_txtCreditCardNumber")
	WebElement cardnumber;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_ddlCreditCardExpireMonth")
	WebElement month;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_ddlCreditCardExpireYear")
	WebElement year;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_Content_chkTermsAndConditions")
	WebElement termsconditions;
	
	@FindBy(how=How.ID, using="ctl00_ctl00_cphMainContent_FooterButton_btnSubmitDetails")
	WebElement submitdetails;
	
	public void getPageTitle() {
		System.out.println("Page 4 Title : " + driver.getTitle());
	}
	
	public String actualpagename() {
		return pagename.getText();
	}
	
	public void enterdetails() throws Exception{
		ExcelData excel = new ExcelData();	
	Select titlelist = new Select(title);
	titlelist.selectByValue(excel.fieldvalue(4));
	
	firstname.sendKeys(excel.fieldvalue(5));
	lastname.sendKeys(excel.fieldvalue(6));
	
	Select prefixlist = new Select(prefix);
	prefixlist.selectByValue(excel.fieldvalue(7));
	
	telephone.sendKeys(excel.fieldvalue(8));
	email.sendKeys(excel.fieldvalue(9));
	addresslineone.sendKeys(excel.fieldvalue(10));
	
	Select countrylist = new Select(country);
	countrylist.selectByValue(excel.fieldvalue(11));
	
	city.sendKeys(excel.fieldvalue(12));
	zipcode.sendKeys(excel.fieldvalue(14));
	
	Select cardtypelist = new Select(cardtype);
	cardtypelist.selectByValue("DC");
	
	cardnumber.sendKeys(excel.fieldvalue(15));
	cardtypelist.selectByValue(excel.fieldvalue(16));
	
	month.sendKeys(excel.fieldvalue(17));
	year.sendKeys(excel.fieldvalue(18));
	
	termsconditions.click();
	}

	public SwPage05 submitdetails() throws Exception {
		clickAction(submitdetails);
//		submitdetails.click();
		return new SwPage05();
	}

}
