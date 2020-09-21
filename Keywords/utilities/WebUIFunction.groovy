package utilities

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory


/**
 * For setup window browser resolution using parameter "percentage" file.
 * call this keyword and add percentage e.g "100" for 100% resolution
 */
@Keyword
public void WebUIFunction(String percentage) {
		WebDriver driver = DriverFactory.getWebDriver()
		JavascriptExecutor js = ((driver) as JavascriptExecutor)
		js.executeScript("document.body.style.zoom=\'"+percentage+"\'")
}
