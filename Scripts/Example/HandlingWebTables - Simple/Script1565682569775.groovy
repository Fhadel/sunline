import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://jofis-sit.apps.dev.corp.btpn.co.id/')

WebUI.delay(20)

WebDriver driver = DriverFactory.getWebDriver()
String sessionID = GlobalVariable.sesID
WebElement agreement = driver.findElement(By.id('select2-filterAgreement-container'))
println agreement.getText()

WebElement Table = driver.findElement(By.cssSelector('table.table:nth-child(2) > tbody'))
List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
println rows_table
for (int row = 0; row < rows_table.size(); row++) {
	List<WebElement> Columns_head = rows_table.get(row).findElements(By.tagName('td'))
		String celltext = Columns_head.get(2).getText()
		println celltext
		if (celltext != null) {
			String a = Columns_head.get(2).getText()
			print a
			WebUI.delay(3)
			//driver.findElement(By.id("Kembali")).click()
			break
	}
}



