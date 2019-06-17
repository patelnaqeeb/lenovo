package com.fpl;

import java.time.LocalTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Course {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://test.safetynet.dk/SafetyNetDev_SIT/");
		  driver.manage().window().maximize();
		  
		  WebElement username = driver.findElement(By.xpath("//INPUT[@id='_loginControl__txtLoginUserName']"));
		  username.sendKeys("Jane");
		  
		  WebElement password = driver.findElement(By.xpath("//INPUT[@id='_loginControl__txtLoginPassword']"));
		  password.sendKeys("123456");
		  
		  WebElement _loginbtn = driver.findElement(By.xpath("//INPUT[@id='_loginControl__btnLogin']"));
		  _loginbtn.click();
		  
			/*Mouse hover activity*/
		  	WebElement activity = driver.findElement(By.linkText("Activity"));
			 
			  /* Find activity search menu and click on it */
		  	  Actions action = new Actions(driver);
			  action.moveToElement(activity).perform();
			  
			  WebElement activitySearch = driver.findElement(By.linkText("Activity search"));
			  
			  action.moveToElement(activitySearch);
			  action.click();
			  action.perform();
			  
			  //Click on create new Activity button
			  driver.findElement(By.id("ctl00_masterContent__fplActivitySearch__btnNew_input")).click();
			  
			  //Wait for 5Sec to load activity edit screen
			  Thread.sleep(8000);
			  
			  //Input activity name 
			  WebElement activityName = driver.findElement(By.xpath("//INPUT[@name='ctl00$masterContent$_fpActivityEditor$_txtActivityName']")); 
			  activityName.click();
			  activityName.sendKeys("Selenium activity" + LocalTime.now());
				  
			  driver.findElement(By.xpath("//input[@id='ctl00_masterContent__fpActivityEditor__btnGenerateNewCode']")).click();
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//input[@id='ctl00_masterContent__fpActivityEditor__btnSave']")).click();
			  
			  Thread.sleep(5000);
			  driver.close();
	}

}
