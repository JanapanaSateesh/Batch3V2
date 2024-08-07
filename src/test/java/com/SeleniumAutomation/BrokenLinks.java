package com.SeleniumAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://demoqa.com/broken");
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 
		 List<WebElement> list= driver.findElements(By.tagName("a"));
		 
		 ArrayList<String> listoflinks=new ArrayList<String>();
		 for(WebElement ele: list) 
		 {
			 String str=ele.getAttribute("href");
			 //System.out.println(str);
			 listoflinks.add("Links: "+str);
			 

			 if(str==null)
			 {
				 //System.out.println("This is null");
			 }
			 else {
				 
				 URL link=new URL(str);
				 HttpURLConnection conn= (HttpURLConnection)link.openConnection();
				 conn.setConnectTimeout(3000);
				 conn.connect();
				 if(conn.getResponseCode() == 200) {
					 
				 }else {
					 System.out.println(str+ " "+ conn.getResponseMessage()+" --"+"is a broken link");
				 }
			 }

		 }
		 
		 
	}

}
