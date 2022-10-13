package trial;

import java.util.List;

import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.MouseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ErrorMSgOnDateSelection {
	public String selectCheckOutDate(String Str_month, String Str_checkoutDate)
	{
		log.debug("Iterating through the months of year");
		while(!driver.findElement(By_datePickerMonth).getText().contains(Str_month))
		{
			click(By_nextMonthNavButton, ExplicitWaitExpectedConditions.NONE);
			log.debug("Clicked on next month navigation button");
		}
		log.info("Selected month for checkout date");
		List<WebElement> days = findElements(By_daysOfMonth);
		log.debug("Retrived all days of selected month");
		int daysCount = days.size();
		int counter=0;
		String Str_dateBackgroundColorRGB=null;
		String Demo= null;
		log.debug("Iterating through each day of selected month");
		//Traverse trough eac day of selected month
		for(int i=0;i<daysCount;i++)
		{
			//Conditional check to select given date
			if(days.get(i).getText().equals(Str_checkoutDate))
			{
				//Mouse hover action on dates to retrieve selection status of cell
				MouseActions.mouseHover(days.get(i));
				//Retrieving list of selected dates between checkin & checkout
				List<WebElement> selectedDates = findElements(By.xpath("//div[@class='DayPicker-Months']//div[contains(@class,'DayPicker-Day--selected')]"));
				System.out.println("Selected Dates: "+selectedDates.size());
				//Checking status of attribute "area-selected" for each web element(date)
				for(int j=0;j<selectedDates.size();j++)
				{
					String selectionStatus = selectedDates.get(j).getAttribute("aria-selected");
					//incrementing counter if status is trues for further validation of error message
					if(selectionStatus.equals("true"))
					{
						counter++;
						if(counter>30)
						{
							Demo = getText(By.id("range_error"));
							break;
						}
					}
				}
//				Str_dateBackgroundColorRGB = days.get(i).getCssValue("background-color");
//				log.debug("Retrieved selected date cell background color");
				days.get(i).click();
				log.info("Selected checkout date");
				System.out.println("Counter: "+counter);
				break;
			}
		}
		
		
		log.info("Selcted check in month as "+Str_month+" & check in date as "+Str_checkoutDate);
//		return Color.fromString(Str_dateBackgroundColorRGB).asHex();
		return Demo;
	}



}
