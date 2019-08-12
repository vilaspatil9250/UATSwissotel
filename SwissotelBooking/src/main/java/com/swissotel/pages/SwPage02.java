package com.swissotel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.swissotel.base.BaseClass;

public class SwPage02 extends BaseClass {

	public SwPage02() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void getPageTitle() {
		System.out.println("Page 2 Title : " + driver.getTitle());
	}

	public void SelectRoomGroup(String roomGroupName) {
		WebElement roomgroup = driver.findElement(By.xpath("//*[@id='btnContentContainer']"));
//		WebElement roomgroup = driver.findElement(By.xpath("//*[@id='btnContentContainer']/span[contains(text(),'"+roomGroupName+"')]"));
		roomgroup.click();
	}

	public void SelectRoomType(String roomTypeName) {
		WebElement roomgtype = driver.findElement(
				By.xpath("//*[@id='btnRoomContentContainer']/span[contains(text(),'" + roomTypeName + "')]"));
		roomgtype.click();
	}

	public void SelectRoomGroup() {
		WebElement roomgroup = driver.findElement(By.xpath("//*[@id='btnContentContainer']"));
		roomgroup.click();
	}

	public void SelectRoomType() {
		WebElement roomgtype = driver.findElement(By.xpath("//*[@id='btnRoomContentContainer']"));
		roomgtype.click();
	}

	@FindBy(how = How.ID, using = "ctl00_ctl00_cphMainContent_Content_rptRCMain_ctl00_rptRCRoomContainer_ctl00_rptRooms_ctl00_lnkbtnSlectContinue")
	WebElement selectRoom;

	public SwPage03 selectRoomContinue() throws IOException {
//		SelectRoomGroup("Daily Flexible Rate");
		// SelectRoomGroup("Room only - Non Refundable Save 10%");
		// SelectRoomType("Classic");
		SelectRoomGroup();
		SelectRoomType();
		Actions action = new Actions(driver);
		action.moveToElement(selectRoom).click().build().perform();
//		selectRoom.click();
		return new SwPage03();
	}
}