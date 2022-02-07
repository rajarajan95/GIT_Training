package com.saucelabs.stepdefinitions;

import org.junit.Assert;

import com.saucelabs.functionlibraries.BasePage;
import com.saucelabs.pageobjects.LoginPage;
import com.saucelabs.pageobjects.ProductsPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions extends BasePage {
	LoginPage login;
	ProductsPage product;
	
	@Before
	public void setup() {
		BasePage.initialization();
		login=new LoginPage();
	}
	
	@Given("user has account in saucelabs")
	public void user_has_account_in_saucelabs() {
		String username=prop.getProperty("username");
	   login.checkValidUser(username);
	}
	@When("user enters user name")
	public void user_enters_user_name() {
	    String username=prop.getProperty("username");
	    login.enterUsername(username);
	}
	@When("user enters password")
	public void user_enters_password() {
	    String password=prop.getProperty("password");
	    login.enterpassword(password);
	}
	@Then("login should be successful")
	public void login_should_be_successful() {
	    product=login.clickLoginBtn();
		String title=product.getPageTitle();
		Assert.assertEquals("Swag Labs", title);
	}
	
	@When("user enters invalid user name")
	public void user_enters_invalid_user_name() {
		    login.enterUsername("Raja");
	}
	@When("user enters invalid password")
	public void user_enters_invalid_password() {
	    login.enterpassword("secretsauce");
	}
	@Then("login should not be successful")
	public void login_should_not_be_successful() {
	   login.clickLoginBtn();
	  Assert.assertTrue(login.isErrorTextPresent());
	  String errtext=login.getErrorMessage();
	  Assert.assertEquals(errtext, "Epic sadface: Username and password do not match any user in this service");
	}



}
