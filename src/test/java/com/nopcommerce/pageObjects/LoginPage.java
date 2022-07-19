package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtemail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtpwd;

	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnlogin;

	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement btnLogout;

	public void SetUsername(String uname) throws InterruptedException {
		txtemail.clear();
		txtpwd.clear();
		Thread.sleep(2000);
		txtemail.sendKeys(uname);
	}

	public void Setpassword(String pwd) throws InterruptedException {
		txtpwd.sendKeys(pwd);
	}

	public void ClickLogin() {
		btnlogin.click();
	}

	public void ClickLogout() {
		btnLogout.click();
	}
}
