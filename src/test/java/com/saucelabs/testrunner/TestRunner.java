package com.saucelabs.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\saucelabs\\featurefiles\\SauceLabsProductsTest.feature",
glue = "com/saucelabs/stepdefinitions",
dryRun = false,
monochrome = true,
tags="not @ignore",
plugin = "json:target/cucumber-report.json",
publish = true)
public class TestRunner {

}
