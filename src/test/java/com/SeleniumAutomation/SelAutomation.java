package com.SeleniumAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import junit.framework.Assert;

public class SelAutomation {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		

		//test1();
		test2();
		//checkBox();
		//linkTest();
		//getWindows();


	}
	
	public static void test1() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 WebDriver driver=new ChromeDriver(options);
		 driver.get("https://demoqa.com/text-box");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("userName")).sendKeys("Jyothirmaia");
		 driver.findElement(By.id("userEmail")).sendKeys("Jyothirmaia@gmail.com");
		 driver.findElement(By.id("currentAddress")).sendKeys("1-29, Hitech city- Hyderabad 500083");
		 driver.findElement(By.id("permanentAddress")).sendKeys("1-29, Hitech city- Hyderabad 500083");
		 Thread.sleep(6000);
		 
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,300)");
		 
		 Thread.sleep(2000);
		 driver.get("https://www.flipkart.com/");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//button[text()='Request OTP']")).click();
		 
		 String errormsg=driver.findElement(By.xpath("//label[text()='Enter Email/Mobile number']/following-sibling::span")).getText();
		 System.out.println(errormsg);
		
		 Assert.assertEquals("Please enter valid Email ID/Mobile number", errormsg);
		 driver.close();
	}
	
	
	public static void test2() throws InterruptedException, AWTException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 WebDriver driver=new ChromeDriver(options);
		 driver.get("https://demoqa.com/automation-practice-form");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("firstName")).sendKeys("Sateesh M");
		 driver.findElement(By.id("userEmail")).sendKeys("Sateesh@gmail.com");
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,300)");
		 
		 Thread.sleep(4000);

		 //driver.findElement(By.xpath("//input[@id='uploadPicture']")).click();
		 StringSelection str = new StringSelection("C:\\Users\\sai krishna\\Documents\\selenium.png");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
		 
		 js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id='uploadPicture']")));
		 Thread.sleep(4000);
		  // Robot object creation
	      Robot r = new Robot();
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void checkBox() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 WebDriver driver=new ChromeDriver(options);
		 driver.get("https://demoqa.com/checkbox");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 WebElement ele= driver.findElement(By.xpath("//span[text()='Home']"));
		 if(ele.isSelected()) {
			 System.out.println("It is clicked");
		 }
		 else {
			 ele.click();
			 System.out.println("Earlier it is not clicked, now it is clicked");
		 }
	}
	
	public static void linkTest() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 WebDriver driver=new ChromeDriver(options);
		 driver.get("https://demoqa.com/links");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 //driver.findElement(By.xpath("//a[text()='No Content']")).click();
		 driver.findElement(By.linkText("No Content")).click();
		 Thread.sleep(5000);
	}
	
	public static void getWindows() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		 WebDriver driver=new ChromeDriver(options);
		 driver.get("https://demoqa.com/links");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("Home")).click();
		 String parentwindow=driver.getWindowHandle();
		 System.out.println("Parent window: "+parentwindow);
		 
		 Set<String> str= driver.getWindowHandles();
		 System.out.println(str);
		 
		 Iterator<String> itr=str.iterator();
		 while(itr.hasNext()) {
			 String child_window=itr.next();
			 if(!parentwindow.equals(child_window)) {
				 System.out.println("Switched to second window: "+child_window);
				
				 driver.switchTo().window(child_window);
				 JavascriptExecutor js= (JavascriptExecutor)driver;
				 js.executeScript("window.scrollBy(0,300)");
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//*[text()='Forms']")).click();
			 }
		 }
		 
		 driver.switchTo().window(parentwindow);
		 Thread.sleep(5000);
		 driver.findElement(By.linkText("Moved")).click();
		 
	}

}
