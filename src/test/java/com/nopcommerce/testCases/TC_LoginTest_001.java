package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseurl);

		logger.info("Url is Opened");
		LoginPage lp = new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("usename is applied");
		lp.Setpassword(password);
		logger.info("password is applied");
		lp.ClickLogin();

		Thread.sleep(5000);

		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
			Assert.assertTrue(true);
			lp.ClickLogout();
			logger.info("Logout");

		} else {
			captureScreen(driver, "loginTest");
			logger.info("Login Failed");// logger msg
			Assert.assertTrue(false);

		}
	}

}
