package com.Kmslearn.Selenium;

import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class Browser {
	public static WebDriver driver;
	public String OSName = System.getProperty("os.name").toLowerCase();
	@BeforeTest
	@Parameters("browser")
	public void Setbrowers(String browser){
		// TODO Auto-generated method stub
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator
							+ (OSName.contains("win") ? "win_driver" + File.separator + "chromedriver.exe"
									: "mac_driver" + File.separator + "chromedriver"));
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + File.separator + "driver" + File.separator
							+ (OSName.contains("win") ? "win_driver" + File.separator + "geckodriver.exe"
									: "mac_driver" + File.separator + "geckodrive.tar"));
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://demo.getsaleor.com/en/");
	}
	@AfterTest
	public void QuitDriver() throws InterruptedException {
		Thread.sleep(2000);
	//	driver.close();
	}
}
