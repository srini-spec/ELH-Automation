package com.cleartrip.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="features",glue="com.cleartrip.stepDef",
                 plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class runnerTest extends AbstractTestNGCucumberTests {

}
