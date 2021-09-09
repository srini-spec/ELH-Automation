package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StepDefinition {

	WebDriver driver;
	@Given("user navigates to the browser")
	public void user_navigates_to_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\Users\\LARCHANA\\Downloads\\Chromedriver\\chromedriver.exe");

	      driver =  new ChromeDriver();
	      driver.get("https://www.facebook.com/");
	}

	@And("user enters username and password")
	public void user_enters_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.id("email")).sendKeys("Archana");
	    driver.findElement(By.id("pass")).sendKeys("Archana@87");
	}	
}
