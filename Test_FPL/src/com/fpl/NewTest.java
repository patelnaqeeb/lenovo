package com.fpl;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
	
	public String baseUrl ="https://test.safetynet.dk/SafetyNetDev_SIT/";
	public WebDriver driver;
	
	
  @BeforeTest(alwaysRun = true)
  
  
  public void setup()
  {
	  System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
  }
  
  @Test(priority =1)
  public void login() 
  {
	  WebElement username = driver.findElement(By.xpath("//INPUT[@id='_loginControl__txtLoginUserName']"));
	  username.sendKeys("Jane");
	  
	  WebElement password = driver.findElement(By.xpath("//INPUT[@id='_loginControl__txtLoginPassword']"));
	  password.sendKeys("123456");
	  
	  WebElement _loginbtn = driver.findElement(By.xpath("//INPUT[@id='_loginControl__btnLogin']"));
	  _loginbtn.click();
	  
  }
  
  @Test(priority =2)
  public void createActivity() throws InterruptedException
  {
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
		  
		  //Instantiate calendar function
		 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(new Date());
		 cal.add(Calendar.DATE, 10);
		 String actFromDate = dateFormat.format(cal.getTime());
		 
		 WebElement fromDate = driver.findElement(By.xpath("//input[@id ='ctl00_masterContent__fpActivityEditor__dateFrom_dateInput']"));
		 fromDate.sendKeys(actFromDate);
		 
		 cal.add(Calendar.DATE, 20);
		 String actToDate = dateFormat.format(cal.getTime());
		 WebElement toDate = driver.findElement(By.xpath("//input[@id ='ctl00_masterContent__fpActivityEditor__dateTo_dateInput']"));
		 toDate.sendKeys(actToDate);
		 
		 WebElement deadLineDate = driver.findElement(By.xpath("//input[@id ='ctl00_masterContent__fpActivityEditor__radEnrollDeadLine_dateInput']"));
		 deadLineDate.sendKeys(actFromDate);
		  //driver.findElement(By.xpath("//input[@id='ctl00__loginStatus']")).click();
		 
		 WebElement cancellationDeadLineDate = driver.findElement(By.xpath("//input[@id ='ctl00_masterContent__fpActivityEditor__radCancellationDeadline_dateInput']"));
		 cancellationDeadLineDate.sendKeys(actFromDate); 
		 
		 driver.findElement(By.xpath("//input[@id ='ctl00_masterContent__fpActivityEditor__txtMaxParticipants']")).sendKeys("35");
		 driver.findElement(By.xpath("//input[@id ='ctl00_masterContent__fpActivityEditor__txtMaxDepartmentParticipants']")).sendKeys("10");
		 driver.findElement(By.xpath("//input[@id ='ctl00_masterContent__fpActivityEditor__txtMinParticipants']")).sendKeys("30");
		 
		 
		 WebElement btnSave = driver.findElement(By.xpath("//input[@id='ctl00_masterContent__fpActivityEditor__btnSave']"));
		 btnSave.click();
  }
  
  @Test(priority = 3)
  public void addActivityLocation() 
  {
	  
	 Select location = new Select(driver.findElement(By.name("ctl00$masterContent$_fpActivityEditor$_cboLocation")));
	 location.selectByVisibleText("Per Aarsleff A/S");
	 
	 /*WebElement btnInstructorAdd = driver.findElement(By.xpath("//INPUT[@id='ctl00_masterContent__fpActivityEditor__activityModuleInstructorList__btnAddInstructor']"));
	 btnInstructorAdd.click();
	 
	 WebElement instructor = driver.findElement(By.xpath("//input[@name='ctl00$masterContent$_fpActivityEditor$_activityModuleInstructorList$_cboInstructor']"));
	 instructor.sendKeys("Sure");
	 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//li[contains(.,'Suresh krypteret pga. GDPR. [sureshc@frontavenue.com]')]")).click();
	 
	 //WebDriverWait wait = new WebDriverWait(driver, 15);
	 //wait.until(ExpectedConditions.elementToBeClickable(By.id("EnvironmentId")));*/
	 
	 WebElement btnSave = driver.findElement(By.xpath("//input[@id='ctl00_masterContent__fpActivityEditor__btnSave']"));
	 btnSave.click();
	 
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
  }
  
  @Test(priority = 4)
  
  public void enrollParticipant()
  {
	  driver.findElement(By.xpath("//a[@id='ctl00_masterContent__fpActivityEditor__lnkCatalogEnrollmentDescription']")).click();
	  //WebElement btnEnroll = driver.findElement(By.xpath("//a[@id='ctl00_masterContent__faActivityDescription__btnSignUp']"));
	  //btnEnroll.click();
	  
	  driver.findElement(By.id("ctl00_masterContent__faActivityDescription__btnSignUp")).click();
	  
	  
	  
  }
}
