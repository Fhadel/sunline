package common


import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory

public class openBrowser {
	def path = "C:\\Users\\18056856\\Downloads\\Katalon_Studio_Windows_64-6.1.4\\Katalon_Studio_Windows_64-6.1.4\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe"
	def path2 = ""
	
	@Keyword
	def openBrowserChrome(String url) {
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get(url)
		DriverFactory.changeWebDriver(driver);
	}
}