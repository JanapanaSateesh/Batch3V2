package com.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverCls {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.browserstack.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 
		 Actions act= new Actions(driver);
		 act.moveToElement(driver.findElement(By.xpath("//button[@aria-label='Products']"))).perform();
	}

}
