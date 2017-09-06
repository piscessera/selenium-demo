package com.sample.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestGoogleDynamicElement {

	public static void main(String[] args) throws InterruptedException {
		// Use silent mode
//		WebDriver driver = new HtmlUnitDriver();
//		System.out.println("Browser: " + driver.getBrowserVersion());
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Current URL: " + driver.getCurrentUrl());

		driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		List<WebElement> childElements = driver.findElements(By.cssSelector("li.sbsb_c.gsfs > div:first-child[role='option']"));
		
		for (WebElement childElement : childElements) {
			System.out.println(childElement.getText());
		}

		driver.close();
		System.out.println("=================");
		System.out.println("Finish!");
	}
}