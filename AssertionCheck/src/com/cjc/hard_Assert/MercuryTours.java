package com.cjc.hard_Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercuryTours 
{
	WebDriver driver;

	@BeforeSuite
	public void Open_Browser()
	  { System.setProperty("webdriver.chrome.driver","E:\\exe\\chromedriver.exe" );
	    driver=new ChromeDriver();
		System.out.println("OPen the browser");
	}
	
	

	@BeforeTest
	public void Luanch_url ()
	{driver.get("http://demo.guru99.com/test/newtours/");
		System.out.println("launch the url");
	}

	
	@BeforeClass
	public void Maximize_browser ()
	 { driver.manage().window().maximize();
		System.out.println("miximize browser");
	}
	
	
	@Test(dataProvider="getData")
	public void Assert_Demo(String userName,String  password )
	{  String j = driver.getTitle();
	  System.out.println("Your page title Is : "+j);
	  Assert.assertEquals("Welcome: Mercury Tours",j);
	  
	  String url=driver.getCurrentUrl();
	  System.out.println("current url is:"+url);
	  Assert.assertEquals("http://demo.guru99.com/test/newtours/",url);
	
	driver.findElement(By.xpath("//*[@name=\"userName\"]")).sendKeys(userName);
	 Assert.assertEquals("shwetakale",userName);
	System.out.println("the given usernameis:"+userName);
		
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys( password);
		 Assert.assertEquals("shweta29",password);
		System.out.println("The givenPassword is:"+password);
				
		driver.findElement(By.xpath("//*[@name=\"submit\"]")).click();
		
		boolean we=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).isDisplayed();
		System.out.println("print:"+we);
		
		boolean we1=driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/p[1]/img")).isDisplayed();
		System.out.println("print:"+we1);
		
	}
	
	@DataProvider(name="getData")
	public Object[][]getData()
	{Object data[][]=new Object[1][2];
		data[0][0]="shwetakale";
		data[0][1]="shweta29";
	
	
	return data;
		
	}
	
	
	
}
