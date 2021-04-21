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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Automationpractice 


{WebDriver driver;

@BeforeSuite
public void Open_Browser()
{System.setProperty("webdriver.chrome.driver","E:\\exe\\chromedriver.exe" );
driver=new ChromeDriver();

}


@BeforeTest
public void Luanch_url ()
{driver.get("http://automationpractice.com/index.php");
	System.out.println("launch the url");
}


@BeforeClass
public void Maximize_browser ()
{driver.manage().window().maximize();
	System.out.println("miximize browser");
}


@BeforeMethod
public void Accept_Cookies ()
{Set<Cookie> cookies=driver.manage().getCookies();
int count=cookies.size();
System.out.println("size of cookies"+count);
Cookie c=new Cookie("xyz", "shweta");
driver.manage().addCookie(c);
Set<Cookie> cookies1=driver.manage().getCookies();
int count1=cookies1.size();
System.out.println("size of cookies"+count1);
System.out.println("Accept the cookies");
	System.out.println("Accept the cookies");
}


@org.testng.annotations.Test
public void Test()
{ 
driver.findElement(By.xpath("//*[@class=\"login\"]")).click();
driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("kale46hgjd@gmail.com");;
driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
driver.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("shweta");
driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("kale");
driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("hgddjs16jd@gmil.com");
driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("shweta29");

WebElement we=driver.findElement(By.xpath("//*[@id=\"days\"]"));
Select sel=new Select(we);
sel.selectByVisibleText("29");

WebElement we1=driver.findElement(By.xpath("//*[@id=\"months\"]"));
Select sel1=new Select(we1);
sel1.selectByVisibleText("August");


WebElement we2=driver.findElement(By.xpath("//*[@id=\"years\"]"));
Select sel2=new Select(we2);
sel2.selectByVisibleText("1995");


driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("shweta");
driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("kale");
driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("gedjs");
driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("pune");
driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("pune2");
driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("pune");

WebElement we3=driver.findElement(By.xpath("//*[@id=\"id_state\"]"));
Select sel3=new Select(we3);
sel.deselectByVisibleText("california");
driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("45235");


WebElement we4=driver.findElement(By.xpath("//*[@id=\"id_country\"]"));
Select sel4=new Select(we4);
sel4.deselectByVisibleText("unites states");

driver.findElement(By.xpath("//*[@id=\"other\"]")).sendKeys("hello welcome to new page");
driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("123567895");
driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("54975235634");
driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("amravati");
driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();

System.out.println("Test");
}


@AfterMethod
public void Take_Screenshot() throws IOException
{ File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src ,new File("C:\\screenshot\\image3.jpg"));
System.out.println("TakeScreenshot");
	System.out.println("TakeScreenhot");
}


@AfterClass
public void DeleteCookies()
{
	driver.manage().deleteCookieNamed("PrestaShop-a30a9934ef476d11b6cc3c983616e364");
	Set<Cookie> cookies3=driver.manage().getCookies();
	int count23=cookies3.size();
	System.out.println("Total noofcookies:"+count23);	
	System.out.println("Delete cokkies");
}


@AfterTest
public void Db_close ()
{
	System.out.println("Close database");
}


@AfterSuite
public void close_Allwindows()
{driver.quit();
	System.out.println("close the windows");
}



}
