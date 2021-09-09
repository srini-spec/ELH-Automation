package com.cleartrip.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bookpage {

	WebDriver driver;

	By NO_OF_FLIGHTS = By.xpath("//div[@class='px-4']//span");

	public Bookpage(WebDriver driver) {
		this.driver = driver;
	}

	public void flightbook() {

		driver.findElement(NO_OF_FLIGHTS).isDisplayed();
		String flightsno = driver.findElement(NO_OF_FLIGHTS).getText();
		System.out.println(flightsno);
	}

}
