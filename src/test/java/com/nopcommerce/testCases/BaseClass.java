package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();
	String baseurl = rc.readUrlfromConfigFile();

	WebDriver driver;

	String username = rc.readUsernamefromConfigFile();
	String password = rc.readpasswordfromConfigFile();
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass

	public void Setup(String br) {

		logger = Logger.getLogger("ECommerce");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", rc.readpathfromConfigFile());

			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", rc.readfirefoxpath());
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

	}

	@AfterClass
	public void tearDown() {

		driver.close();
		System.out.println("Browser closed");
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(Source, Target);
		System.out.println("ScreenShot Captured");

	}

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
