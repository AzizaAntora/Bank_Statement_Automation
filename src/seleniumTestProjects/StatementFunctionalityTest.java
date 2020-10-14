package seleniumTestProjects;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatementFunctionalityTest {

	public static void main(String[] args) {
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aziza Sultana\\eclipse-workspace\\JavaProject\\Drivers\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost:9999/statements");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");

		WebElement selectFromDate = driver.findElement(By.xpath("//*[@id=\"from_datepicker\"]/span"));
		selectFromDate.click();
	
	    WebElement nextFromLink = driver.findElement(By.xpath("//*[@id=\"from_datepicker\"]/span"));
	    nextFromLink.click();


	    WebElement selectToDate = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
		selectToDate.click();


	    WebElement nextToLink = driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/span"));
	    nextToLink.click();
		
		try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    
	    driver.findElement(By.xpath("/html/body/div/nav/a/span")).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"search_account_id\"]")).sendKeys("101101");
	    
	    WebElement dateFromBox = driver.findElement(By.name("from_date"));
	    dateFromBox.click();
		
	    dateFromBox.sendKeys("2020-01-01 00:00:00");
	    
	    driver.findElement(By.xpath("//*[@id=\"to_datepicker\"]/input")).click();
	    
	    WebElement dateToBox = driver.findElement(By.name("to_date"));
	    dateToBox.click();
		
	    dateToBox.sendKeys("2020-10-12 00:00:00");

	    driver.findElement(By.xpath("/html/body/div/form/button")).click();
	    
	    try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	    
	    driver.findElement(By.xpath("/html/body/div/nav/a/span")).click();
	        	   
    }

}


