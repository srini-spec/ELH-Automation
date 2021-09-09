package com.cleartrip.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Searchpage {
	WebDriver driver;
	Searchpage sp;

	By TEXTBOX_FROM = By.xpath("//div[@class='p-relative']/input");
	By TEXTBOX_To = By.xpath("(//div[@class='p-relative']/child::input)[2]");
	By SEARCH = By.xpath("//button[text()='Search flights']");
	By SEARCL_LIST_FROM = By.xpath("//div[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-1 z-50 l-0']/ul/li");
	By SEARCL_LIST_TO = By.xpath("//div[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-1 z-50 l-0']/ul/li");
	By SEARCH_ERROR = By
			.xpath("//div[@class='w-100p p-4 br-4 flex flex-middle flex-between elevation-3 bg-error-600 row']/span");

	public Searchpage(WebDriver driver) {
		this.driver = driver;
	}

	public void search() throws InterruptedException {

		WebElement element = driver.findElement(SEARCH);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		String expectedres = driver.findElement(SEARCH_ERROR).getText();
		System.out.println(expectedres);
		String actualres = "Select Departure and Arrival airports/cities.";

		Assert.assertEquals(actualres, expectedres);
		Assert.assertTrue(true);
		sp = new Searchpage(driver);
		sp.fillsearch();
	}

	public void fillsearch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 6);

		// Auto suggestions
		driver.findElement(TEXTBOX_To).clear();
		driver.findElement(TEXTBOX_FROM).click();

		WebElement from = driver.findElement(TEXTBOX_FROM);
		from.sendKeys("chennai");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCL_LIST_FROM)).click();

		driver.findElement(TEXTBOX_To).clear();
		driver.findElement(TEXTBOX_To).click();
		WebElement to = driver.findElement(TEXTBOX_To);
		to.sendKeys("bangalore");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCL_LIST_TO)).click();

		// DROPDOWN ADULT
		Select adult = new Select(driver.findElement(By.xpath("//select[@class='bc-neutral-100 bg-transparent']")));
		adult.selectByIndex(0);
		// DROPDOWN CHILDREN
		Select children = new Select(
				driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]")));
		children.selectByValue("3");
		// DROPDOWN INFANTS
		Select infants = new Select(
				driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[3]")));
		infants.getFirstSelectedOption();

		driver.findElement(SEARCH).isDisplayed();
		WebElement element1 = driver.findElement(SEARCH);
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		Assert.assertTrue(true, "Search Flight successfully");

	}
}
