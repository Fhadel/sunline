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

Mobile.startApplication(GlobalVariable.pathAPK+"/androidapp/helloTiny-release.apk", false)
/**
 * Step open application and go to signup page
 */
Mobile.waitForElementPresent(findTestObject('SiMobi/Login_Page/LoginPage_Btn_SignUp'), 2)
Mobile.tap(findTestObject('SiMobi/Login_Page/LoginPage_Btn_SignUp'), 2)
Mobile.waitForElementPresent(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Full Name'), 2)

/**
 * Scenario press button next with empty field and expected all error message appear
 */
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_Btn_Next'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorMsg_EmailEmpty'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorMsg_FullNameEmpty'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorMsg_PhoneNumberEmpty'), 0)

/**
 * Scenario set invalid value in all field and expected all error message appear
 */
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_MobileNumber'), "08221", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Full Name'), "Fh#@adda", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Email Address'), "fhadelfadillah@.com", 2)
Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_Btn_Next'), 2)
Mobile.delay(2)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorMsg_InvalidFormatPhoneNumber'), 2)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorMsg_InvalidNameFormat'), 2)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorMsg_InvalidFormatEmail'), 2)

/**
 * Scenario clear all value and input valid value 
 * then press button next without check radio button T&C, 
 * expected error pop up appear and click ok to continue the process
 * 
 */
Mobile.clearText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_MobileNumber'), 0)
Mobile.clearText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Full Name'), 0)
Mobile.clearText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Email Address'), 0)

Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_MobileNumber'), "082112370408", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Full Name'), "Fhadel Achmad Fadillah", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Email Address'), "fhadelfadillah@gmail.com", 2)
Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_Btn_Next'), 2)
Mobile.delay(2)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorPopUp_TermConditionRequired'), 0)
Mobile.verifyElementText(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorPopUp_TermConditionRequired'), "Terms & Conditions are required for further onboarding process. ")
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUpPage_ErrorPopUp_Btn_OK'), 2)

Mobile.closeApplication()
/**
 * Scenario to go next page
 */
//Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_RadioBtn_Agreement'), 2)
//Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_Btn_Next'))
