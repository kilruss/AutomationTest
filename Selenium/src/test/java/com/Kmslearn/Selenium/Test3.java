package com.Kmslearn.Selenium;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test3 extends Browser {
	@DataProvider(name = "Text input")
	public static Object[] credentials() {

		return new Object[] {"This is check noted"};
	}

	@Test(dataProvider = "Text input")
	public void CheckNote(String input ) throws InterruptedException {
		driver.findElement(By.xpath("//header//a[contains(normalize-space(), 'Your account')]")).click();
//		List<WebElement> we2 = new ArrayList<WebElement>();
//		LinkedList<WebElement> lwe = new LinkedList<WebElement>();
		List<WebElement> we = driver
				.findElements(By.xpath("//div[@id='accordion']//a[contains(normalize-space(), 'Details')]"));
		we.get(0).click();
		driver.findElement(By.cssSelector(".order-notes textarea[name~='customer_note']")).sendKeys(input);
		driver.findElement(By.cssSelector("input[type ='submit']")).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(By.cssSelector(".order-notes p")).getText(),input);
		System.out.println(driver.findElement(By.cssSelector(".order-notes p")).getText().contentEquals(input));
	}
}
