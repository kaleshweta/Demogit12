package com.cjc.demogit1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demogit12 
{
	WebDriver driver;
	@org.testng.annotations.Test(priority=1)
	public void Open_browser()
	{
		System.setProperty("webdriver.chrome.driver","E:\\exe\\chromedriver.exe" );
	    driver=new ChromeDriver();
		System.out.println("OPen the browser");
		driver.get("http://demowebshop.tricentis.com/");
		System.out.println("launch the url");
	
	}
	@org.testng.annotations.Test(priority=2)
	public void Test()
	{  driver.findElement(By.xpath("//*[@class=\"ico-register\"]")).click();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//*[@id=\"gender-female\"]")).click();
	   driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("shweta");
	   driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("kale");
	   driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("kale45shweta@gmail.com");
	  	
	}
	@@org.testng.annotations.Test(priority=3)
		public void remain()
	{
	 driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("shweta29");
	   driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("shweta29");
	   driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
	   System.out.println("Test");
	}

}
