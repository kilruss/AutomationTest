package com.Kmslearn.Selenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class Test2 extends Browser {
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		 
        return new Object[][] {{ "admin@example.com", "admin" }};
  }
	@Test(dataProvider = "Authentication")
	public void Login(String username, String password) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//header//a[contains(normalize-space(), 'Log in')]")).click();
		driver.findElement(By.cssSelector(".form-group #id_username")).clear();
		driver.findElement(By.cssSelector(".form-group #id_username")).sendKeys(username);
		driver.findElement(By.cssSelector(".form-group #id_password")).clear();
		driver.findElement(By.cssSelector(".form-group #id_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(normalize-space(), 'Log in')]")).click();
	}
}
