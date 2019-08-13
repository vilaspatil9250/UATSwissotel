package com.swissotel.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;

//	public static void main(String agrs[]) {
//		initization();
//	}

	public BaseClass() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("./Config/config.properties");
		prop.load(ip);
	}

	public static void initization() {

		String browsername = prop.getProperty("Browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\Software Set Up\\Selenium\\WedDrivers\\chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
//		driver.get(prop.getProperty("browser"));
		driver.get(prop.getProperty("URL"));
	}

	
	
	public void close() {
		driver.close();
	}

}
