package com.nopcommerce.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginTest_002 extends BaseClass {
	@Test(dataProvider = "LoginData")
	public void LoginData(String uname, String pwd) throws IOException, InterruptedException {
		driver.get(baseurl);

		logger.info("Url is Opened");

		LoginPage lp = new LoginPage(driver);

		lp.SetUsername(uname);

		logger.info("usename is applied");

		lp.Setpassword(pwd);

		logger.info("password is applied");

		lp.ClickLogin();

		Thread.sleep(2000);

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

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/nopcommerce/loginData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;

	}

}
