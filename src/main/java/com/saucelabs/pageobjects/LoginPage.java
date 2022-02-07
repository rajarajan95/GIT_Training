package com.saucelabs.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucelabs.functionlibraries.BasePage;

public class LoginPage extends BasePage{

	@FindBy(xpath = "//div[@id='login_credentials']") WebElement userlist;
	@FindBy(xpath="//input[@id='user-name']") WebElement usernametxt;
	@FindBy(xpath="//input[@id='password']") WebElement passwordtxt;
	@FindBy(xpath = "//input[@id='login-button']") WebElement LoginBtn;
	@FindBy(xpath="//h3") WebElement loginErrTxt;

public LoginPage() {
	PageFactory.initElements(driver, this);
}

public boolean checkValidUser(String username) {
	int flag=0;
	boolean validusr;
	String userfrompage=userlist.getText();
	String[] userlistarray=userfrompage.split("\n");
	for(String user:userlistarray) {
		if(username.equalsIgnoreCase(user)) {
			flag=1;
		}
	}
	if(flag==1) {
		System.out.println("User already have access");
		validusr=true;
		return validusr;
	}
	else {
		System.out.println("User doesn't have access");
		validusr=false;
		return validusr;
	}
	}
public void enterUsername(String username) {
	usernametxt.sendKeys(username);
}
public void enterpassword(String password) {
	passwordtxt.sendKeys(password);
}
public ProductsPage clickLoginBtn() {
	LoginBtn.click();
	return new ProductsPage();
	
}
public boolean isErrorTextPresent() {
	return loginErrTxt.isDisplayed();
}

public String getErrorMessage() {
	return loginErrTxt.getText();
}

}



