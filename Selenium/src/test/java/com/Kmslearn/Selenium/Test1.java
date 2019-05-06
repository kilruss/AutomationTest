package com.Kmslearn.Selenium;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 extends Browser {
	@Test
	public void SearchTest() {
//Xpath selector
		driver.findElement(By.xpath("//div[@class ='container']//input[contains(@placeholder, 'Search')]")).sendKeys("shirt");
		driver.findElement(By.xpath("//div[@class ='container']//button[@type = 'submit']")).click();
		List<WebElement> ps = driver.findElements(By.xpath("//div[contains(@class,'container maincontent')]//span[contains(@class,'product-list-item')]"));
		ps.stream().forEach(p ->System.out.println(p.getText().toLowerCase().contains("shirt")));
		assert ps.stream().allMatch(p -> p.getText().toLowerCase().contains("shirt"));
//CSS selector		
//		driver.findElement(By.cssSelector("div .container .form-control[placeholder~='Search']")).sendKeys("paint");
//		driver.findElement(By.cssSelector("div .container button[type='submit']")).click();
//		List<WebElement>ps2 = driver.findElements(By.cssSelector("div.container.maincontent span[title]"));
//		ps2.stream().forEach(p ->System.out.println(p.getText()));
	}

}