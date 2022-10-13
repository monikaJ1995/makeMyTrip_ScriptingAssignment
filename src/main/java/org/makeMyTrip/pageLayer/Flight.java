package org.makeMyTrip.pageLayer;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flight {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.get("https://www.makemytrip.com/flights/");
		d.manage().window().maximize();
		
		//click departure
		d.findElement(By.xpath("//div[contains(@class,'dates')]/label[@for='departure']")).click();

//		wait until calendar opens otherwise it will throw no such element exception
		Thread.sleep(3000);
		
//	find month xpath in while loop
		while(!d.findElement(By.xpath("(//div[@class='DayPicker-Month'])[1]")).getText().contains("December"))
		{
			d.findElement(By.cssSelector(".DayPicker-NavButton--next")).click();
		}
		
//		days of month xpath
		List<WebElement> days = d.findElements(By.xpath("(//div[@class='DayPicker-Month'])[1]//div[contains(@class,'DayPicker-Day')]"));
		/**********EXTRA xpaths for days of month*****************
		 * 
		 * //(//div[@class='DayPicker-Month'])[1]/descendant::div[contains(@class,'DayPicker-Day')]
		//(//div[@class='DayPicker-Month'])[1]/descendant::div[@class='dateInnerCell']
		*/
		for(int i=0;i<days.size();i++)
		{
			if(days.get(i).getText().contains("21"))
			{
				JavascriptExecutor js = (JavascriptExecutor)d;
				js.executeScript("arguments[0].click();", days.get(i));
				System.out.println("date selected");
				break;
			}
		}
		
		
	}

}
