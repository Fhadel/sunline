import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

Mobile.startApplication(GlobalVariable.pathAPK + '/androidapp/helloTiny-release.apk', false)
Mobile.waitForElementPresent(findTestObject('Object Repository/SiMobi/Login_Page/LoginPage_MobileNumberTextField'), 2)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/Login_Page/LoginPage_BtnLogin'), 2)
Mobile.setText(findTestObject('Object Repository/SiMobi/Login_Page/LoginPage_MobileNumberTextField'), "0821123456789", 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/LoginPage_BtnLogin'), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/PIN Page/InputPIN_PinTextField'), 2)

Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/PIN Page/InputPIN_PinKeypad1', [('keypad') : 1]), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/PIN Page/InputPIN_PinKeypad1', [('keypad') : 2]), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/PIN Page/InputPIN_PinKeypad1', [('keypad') : 1]), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/PIN Page/InputPIN_PinKeypad1', [('keypad') : 4]), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/PIN Page/InputPIN_PinKeypad1', [('keypad') : 1]), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Login_Page/PIN Page/InputPIN_PinKeypad1', [('keypad') : 2]), 2)
Mobile.delay(5)

Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/Dashboard Page/DashboardPage_AccountNoLabel'), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Dashboard Page/DashboardPage_ProfileBtn'), 2)

Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/Profile age/ProfilePage_LogoutBtn'), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Profile age/ProfilePage_LogoutBtn'), 2)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/Profile age/LogoutPopUP_LabelText'), 2)
Mobile.tap(findTestObject('Object Repository/SiMobi/Profile age/LogoutPopUP_YesBtn'), 2)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/Login_Page/LoginPage_BtnLogin'), 2)