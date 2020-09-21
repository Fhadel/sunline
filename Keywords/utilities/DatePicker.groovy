package utilities

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

public class DatePicker {
	@Keyword
	public static datePicker(String dates) {
		WebDriver driver = DriverFactory.getWebDriver()
		String[] parser = dates.split(" ")
		println parser
		String month = driver.findElement(By.cssSelector(".ui-datepicker-title > span")).getText()
		println month
		if( month != parser[1]){
			//Do Next or Previous Month
		}
	}
}
