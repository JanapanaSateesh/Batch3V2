package com.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsCls {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//This Alert

		
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://demoqa.com/alerts");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//*[@id='alertButton']")).click();
		 Thread.sleep(3000);
		 driver.switchTo().alert().accept();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id=\"promtButton\"]")).click();
		 Thread.sleep(5000);
		 driver.switchTo().alert().sendKeys("Hello");
		 Thread.sleep(3000);
		 driver.switchTo().alert().accept();
	}

}
