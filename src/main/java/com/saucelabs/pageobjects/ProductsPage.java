package com.saucelabs.pageobjects;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.functionlibraries.BasePage;

public class ProductsPage extends BasePage{
	
@FindBy(xpath="//span[@class='title']") WebElement Header;
@FindBy(xpath="//div[@class='inventory_item_label']/a/div") List<WebElement> products;
@FindBy(xpath="//button[@id='back-to-products']") WebElement BacktoProductsBtn;
@FindBy(xpath="//button[starts-with(@id,'add-to-cart')]") WebElement AddtoCartBtn;
@FindBy(id="shopping_cart_container") WebElement CartBtn;
@FindBy(xpath="//div[@class='inventory_item_name']") List<WebElement> selectedProducts;
@FindBy(xpath="//button[@id='checkout']") WebElement checkoutbtn;
@FindBy(id="first-name") WebElement firstName;
@FindBy(id="last-name") WebElement lastName;
@FindBy(id="postal-code") WebElement zipcodetext;
@FindBy(id="continue") WebElement continuebtn;
@FindBy(xpath="//span[@class='title']") WebElement OverviewBar;
@FindBy(id="finish") WebElement finishbtn;
public ProductsPage() {
	PageFactory.initElements(driver, this);
}

public String getPageTitle() {
	return driver.getTitle();
}

public String PageHeader() {
	return Header.getText();
}

public WebElement getProductElement(String product) {
	WebElement matchedElement=null;
	for(WebElement prod:products) {
		String prodText=prod.getText();
		if(product.equalsIgnoreCase(prodText)) {
			matchedElement= prod;
		}
	}
	return matchedElement;
}

public void click(WebElement prod) {
	prod.click();
}

public boolean VerifyBackToProductsDisplayed() {
	return BacktoProductsBtn.isDisplayed();
}

public void clickAddtoCartBtn() {
	AddtoCartBtn.click();
}

public void clickCartBtn() {
	CartBtn.click();
}

public void verifyCart(String prodname) {
	clickCartBtn();
	for(WebElement product:selectedProducts) {
		String selectedprodText=product.getText();
		if(prodname.equalsIgnoreCase(selectedprodText)) {
			System.out.println("selected products available in cart");
		}
	}
}

public void clickCheckOutBtn() {
	checkoutbtn.click();
}

public void fillContactDetails(String fname, String lname, String zipcode) {
	firstName.sendKeys(fname);
	Actions action=new Actions(driver);
	action.sendKeys(lastName, lname).perform();
	/*JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("arguments[0].value='"+zipcode+"';", zipcodetext);*/
	action.sendKeys(zipcodetext,zipcode).perform();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void clickonContinueButton() {
	continuebtn.click();
}

public void clickfinishbutton() {
	finishbtn.click();
}

public boolean checkOverviewDisplayed() {
	return OverviewBar.isDisplayed();
}

public String statusbar() {
	return OverviewBar.getText();
}


}
