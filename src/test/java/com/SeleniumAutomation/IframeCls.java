package com.SeleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeCls {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://demoqa.com/frames");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 driver.switchTo().frame("frame1");
		 String str =driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		 System.out.println(str);
		 
		 Thread.sleep(3000);
		 driver.switchTo().defaultContent();
		 driver.switchTo().frame("frame2");
		 String str1 =driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
		 System.out.println(str1);
	}

}
