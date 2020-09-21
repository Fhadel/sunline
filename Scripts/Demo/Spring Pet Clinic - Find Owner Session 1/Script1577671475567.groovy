import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('http://localhost:8081')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Spring Pet Clinic/HomePage - Menu Tab/ButtonTab - Find Owner'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Spring Pet Clinic/FindOwner Page/Button - AddOwner'))

WebUI.click(findTestObject('Object Repository/Spring Pet Clinic/HomePage - Menu Tab/ButtonTab - Vet'))

WebUI.click(findTestObject('Object Repository/Spring Pet Clinic/HomePage - Menu Tab/ButtonTab - Home'))

WebUI.verifyElementText(findTestObject('Object Repository/Spring Pet Clinic/HomePage - Menu Tab/Text - Welcome'), 'Welcome')

WebUI.closeBrowser()

