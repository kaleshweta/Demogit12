package demopractice;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class demomaven 
{static WebDriver driver;

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


@BeforeMethod
public static void Accept_Cookies ()
{
	
	Set<Cookie> cookies=driver.manage().getCookies();
	int count=cookies.size();
	System.out.println("size of cookies"+count);
	Cookie c=new Cookie("xyz", "shweta");
	driver.manage().addCookie(c);
	Set<Cookie> cookies1=driver.manage().getCookies();
	int count1=cookies1.size();
	System.out.println("size of cookies"+count1);
	System.out.println("Accept the cookies");
}


@org.testng.annotations.Test
public void Test()
{  driver.findElement(By.xpath("//*[@class=\"ico-register\"]")).click();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
   driver.findElement(By.xpath("//*[@id=\"gender-female\"]")).click();
   driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys("shweta");
   driver.findElement(By.xpath("//*[@id=\"LastName\"]")).sendKeys("kale");
   driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("kale77shweta@gmail.com");
   driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("shweta29");
   driver.findElement(By.xpath("//*[@id=\"ConfirmPassword\"]")).sendKeys("shweta29");
   driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
   System.out.println("Test");
	
}


@AfterMethod
public static void Take_Screenshot() throws IOException
{  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src ,new File("C:\\screenshot\\image1.jpg"));
	System.out.println("TakeScreenshot");
}


@AfterClass
public void DeleteCookies()
{
	
	driver.manage().deleteCookieNamed("_utmt");
	Set<Cookie> cookies2=driver.manage().getCookies();
	int count2=cookies2.size();
	System.out.println("Total noofcookies:"+count2);	
	System.out.println("Delete cokkies");
}


@AfterTest
public void Db_close ()
{
	System.out.println("Close database");
}


@AfterSuite
public void close_Allwindows()
{   driver.close();
	System.out.println("close the windows");
}


}
