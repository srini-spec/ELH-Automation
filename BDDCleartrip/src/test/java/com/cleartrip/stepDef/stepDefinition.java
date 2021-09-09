package com.cleartrip.stepDef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.cleartrip.pageobject.Bookpage;
import com.cleartrip.pageobject.Searchpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {
	Properties prop;
	WebDriver driver;
	Searchpage searchflight;
	Bookpage bookflight;

	@Given("Open chrome browser and launch the application")
	public void open_chrome_browser_and_launch_the_application() throws IOException {
		this.prop = new Properties();
		FileInputStream input = new FileInputStream("G:\\javaPrograms\\workspace\\BDDCleartrip\\"
				+ "src\\test\\java\\com\\cleartrip\\configproperties\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srini\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	@When("Searching flight")
	public void searching_flight() throws InterruptedException {

		searchflight = new Searchpage(driver);
		searchflight.search();
		Assert.assertTrue(true, "Search Flight successfully");

	}

	@Then("Booking tickets")
	public void booking_tickets() {

		bookflight = new Bookpage(driver);
		bookflight.flightbook();

	}

}
