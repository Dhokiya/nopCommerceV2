package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File file = new File(".\\Configuration\\config.properties");
		try {
			FileInputStream fl = new FileInputStream(file);
			pro = new Properties();
			pro.load(fl);
		} catch (Exception e) {
			System.out.println("Exception is :  " + e.getMessage());
		}

	}

	public String readUrlfromConfigFile() {
		String url = pro.getProperty("baseurl");
		return url;

	}

	public String readUsernamefromConfigFile() {
		String uname = pro.getProperty("username");
		return uname;

	}

	public String readpasswordfromConfigFile() {
		String pwd = pro.getProperty("password");
		return pwd;

	}

	public String readpathfromConfigFile() {
		String path = pro.getProperty("cromepath");
		return path;

	}

	public String readfirefoxpath() {
		String pathmz = pro.getProperty("firefoxpath");
		return pathmz;
	}

}