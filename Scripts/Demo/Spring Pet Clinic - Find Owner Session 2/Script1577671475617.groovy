import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://localhost:8081')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Spring Pet Clinic/HomePage - Menu Tab/ButtonTab - Find Owner'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Spring Pet Clinic/FindOwner Page/Button - AddOwner'))

//FindOwner Black
String lastNama = 'Black'

WebDriver driver =  DriverFactory.getWebDriver()

WebElement element2 = driver.findElement(By.xpath("//input[@id='lastName']"))
element2.sendKeys(lastNama)

//WebUI.setText(findTestObject('Object Repository/Spring Pet Clinic/FindOwner Page/TxtField - LastName'), lastNama)

WebUI.verifyElementPresent(findTestObject('Spring Pet Clinic/FindOwner Page/Button - FindOwner'), 0)
WebUI.click(findTestObject('Object Repository/Spring Pet Clinic/FindOwner Page/Button - AddOwner'))
//
//WebUI.setText(findTestObject('Object Repository/ByCss', [('css') : '#firstName']), 'aa')
//
//WebUI.setText(findTestObject('Object Repository/ByCss', [('css') : '#lastName']), 'bb')
//
//WebUI.setText(findTestObject('Object Repository/ByCss', [('css') : '#address']), 'cccccccc')
//
//WebUI.setText(findTestObject('Object Repository/ByCss', [('css') : '#city']), 'dddddd')
//
//WebUI.setText(findTestObject('Object Repository/ByCss', [('css') : '#telephone']), '067898781112')
//
//WebUI.delay(15)

