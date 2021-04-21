package com.cjc.softAssert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demowebshop 

{WebDriver driver;

@BeforeSuite
public void Open_Browser()
  { System.setProperty("webdriver.chrome.driver","E:\\exe\\chromedriver.exe" );
    driver=new ChromeDriver();
	System.out.println("OPen the browser");
}

@BeforeTest
public void Luanch_url ()
{driver.get("http://demowebshop.tricentis.com/");
	System.out.println("launch the url");
}


@BeforeClass
public void Maximize_browser ()
 { driver.manage().window().maximize();
	System.out.println("miximize browser");
}

@Test(dataProvider="getData")
public void Assert_Demo(String url,String FirstName,String LastName,String Email,String Password,String ConfirmPassword )
{
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@class=\"ico-register\"]")).click();

   driver.findElement(By.xpath("//*[@id=\"gender-female\"]")).click();
   driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys(FirstName);;
   driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys(LastName);;
   driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Email);
   driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(Password);
   driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys(ConfirmPassword);
   driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
   driver.findElement(By.xpath("//*[@class=\"button-1 register-continue-button\"]")).click();
   driver.findElement(By.xpath("//*[@class=\"ico-logout\"]")).click();
   

}

}
