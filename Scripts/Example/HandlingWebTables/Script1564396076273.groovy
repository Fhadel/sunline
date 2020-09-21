import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('https://nginx-proxy-jofis-sit.apps.dev.corp.btpn.co.id/ui/#/')

//
//WebUI.maximizeWindow()
//
//WebUI.click(findTestObject('Object Repository/JOFis/UsernameTextField'))
//
//WebUI.delay(5)
//
//WebUI.setText(findTestObject('Object Repository/JOFis/UsernameTextField'), 'OPTIMUS1')
//
//WebUI.setText(findTestObject('Object Repository/JOFis/PasswordTextField'), 'P@ssw0rd')
//
//WebUI.click(findTestObject('Object Repository/JOFis/BtnLogin'))
//WebUI.delay(3)
//WebUI.click(findTestObject('Object Repository/JOFis/taskListIcon'))
WebUI.delay(20)

WebDriver driver = DriverFactory.getWebDriver()

String sessionID = GlobalVariable.sesID

'To locate table'
WebElement Table = driver.findElement(By.cssSelector('table.table:nth-child(2)'))

'To locate rows of table it will Capture all the rows available in the table'
	List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
	'To calculate no of rows In table'
		int rows_count = rows_table.size()
		println(rows_count)
	'Loop will execute for all the rows of the table'
		Loops: for (int row = 0; row < rows_count; row++) {
			'To locate columns(cells) of that specific row'
			List<WebElement> Columns_head = rows_table.get(row).findElements(By.tagName('th'))
		
			'To calculate no of columns(cells) In that specific row'
			int columns_count = Columns_head.size()
		
			'Loop will execute till the last cell of that specific row'
			Loop:for (int column = 0; column < columns_count; column++) {
				'It will retrieve text from each cell'
				String celltext = Columns_head.get(column).getText()
		
				'Checking if Cell text is matching with the expected value'
				if (celltext.contains(sessionID)) {
					List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
					String a = Columns_row.get(4).findElement(By.tagName("div")).getText()
					println(a)
					'After getting the Expected value from Table we will do action and Terminate the loop'
					//driver.findElement(By.cssSelector("table.table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(11) > td:nth-child(6) > div:nth-child(1) > span:nth-child(1)")).click()
					WebUI.delay(3)
					driver.findElement(By.id("Kembali")).click()
				}
		}
}
		




