package com.sample.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestBrowserXPath {

	public static void main(String[] args) throws InterruptedException { 
		// Use silent mode
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		System.out.println("Browser: " + driver.getBrowserVersion());
		
		driver.get("http://www.calculator.net/");
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		String gasUrl = driver.findElement(By.xpath(".//a[@href=\"/gas-mileage-calculator.html\"]")).getAttribute("href");
		System.out.println("Get Gas Url: " + gasUrl);
		
		driver.get(gasUrl);
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		driver.findElement(By.xpath(".//*[@id='uscodreading']")).sendKeys("12000");
		driver.findElement(By.xpath(".//*[@id='uspodreading']")).sendKeys("10000");
		driver.findElement(By.xpath(".//*[@id='usgasputin']")).sendKeys("40");
		driver.findElement(By.xpath(".//*[@id='usgasprice']")).sendKeys("4.5");
		driver.findElement(By.xpath(".//input[@value='Calculate' and @type='image']")).click();
		
		Thread.sleep(3000);

		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		String result = driver.findElement(By.xpath(".//font[@color='green']")).getText();
		if ("50.00 miles per gallon".equals(result)) {
			System.out.println("Pass!");
		} else {
			System.out.println("Fail!");
		}
		
		driver.close();
		System.out.println("Finish!");
	}
}
