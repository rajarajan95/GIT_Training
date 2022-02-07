package com.saucelabs.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.saucelabs.functionlibraries.BasePage;
import com.saucelabs.pageobjects.ProductsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ProductStepDefinitions extends BasePage{
	ProductsPage prod;
	
	@Given("user {string} is on products page")
	public void user_is_on_products_page(String username) {
	   String user=prop.getProperty("username");
	   if(username.equals(user)) {
		   System.out.println(user +"logged in");
	   }
	   prod=new ProductsPage();
	   String header=prod.PageHeader();
	  Assert.assertEquals(header, "PRODUCTS");
	}
	@When("user clicks on product {string}")
	public void user_clicks_on_product(String productname) {
	   WebElement product=prod.getProductElement(productname);
	   prod.click(product);
	}
	@Then("product detail page should be displayed")
	public void product_detail_page_should_be_displayed() {
	    Assert.assertTrue(prod.VerifyBackToProductsDisplayed());
	}
	@Then("user clicks on Add to cart")
	public void user_clicks_on_add_to_cart() {
	 prod.clickAddtoCartBtn();   
	}
	@Then("product {string} should be added to cart")
	public void product_should_be_added_to_cart(String name) {
	   prod.verifyCart(name);
	}
	@Then("clicks on the checkout button")
	public void clicks_on_the_checkout_button() {
	    prod.clickCheckOutBtn();
	}
	@Then("user enters the firstname as {string} and lastname as {string} and zipcode as {string}")
	public void user_enters_the_firstname_as_and_lastname_as_and_zipcode_as(String fname, String lname, String zipcode) {
	    prod.fillContactDetails(fname, lname, zipcode);
	}
	@Then("clicks on the continue button")
	public void clicks_on_the_continue_button() {
	 prod.clickonContinueButton();
	}
	@Then("Preview Page should be displayed")
	public void preview_page_should_be_displayed() {
	    Assert.assertTrue(prod.checkOverviewDisplayed());
	}
	@Then("clicks on finish button")
	public void clicks_on_finish_button() {
	    prod.clickfinishbutton();
	}
	@Then("order should be dispatched")
	public void order_should_be_dispatched() {
	    String actual=prod.statusbar();
	    Assert.assertEquals(actual, "CHECKOUT: COMPLETE!");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("closes the browser")
	public void closes_the_browser() {
	    closeBrowser();
	}


}
