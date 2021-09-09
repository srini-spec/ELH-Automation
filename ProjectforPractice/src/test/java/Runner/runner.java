package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



	@CucumberOptions(features="Features",
			glue="Com.StepDefinition",
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	monochrome=true)
	public class runner extends AbstractTestNGCucumberTests{

}

