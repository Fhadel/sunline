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

Mobile.startApplication("C:\\Users\\user\\Katalon Studio\\Sunline_CP3\\androidapp\\helloTiny-release.apk", false)

/**
 * Step open application and go to signup page
 */
Mobile.waitForElementPresent(findTestObject('SiMobi/Login_Page/LoginPage_Btn_SignUp'), 2)
Mobile.tap(findTestObject('SiMobi/Login_Page/LoginPage_Btn_SignUp'), 2)
Mobile.waitForElementPresent(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Full Name'), 2)

Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_MobileNumber'), "082112370408", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Full Name'), "Fhadel Achmad Fadillah", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Email Address'), "fhadelfadillah@gmail.com", 2)
Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_RadioBtn_Agreement'), 2)
Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_Btn_Next'), 2)

Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_BtnOK'), 2)

String OTPText = Mobile.getText(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_OTPText'), 5)
println("========================"+OTPText)

Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_BtnOK'), 2)
Mobile.delay(2)
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_InputOTP'), 2)
Mobile.sendKeys(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/SignUp_OTP_InputOTPText1'), OTPText, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.sendKeys(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/SignUp_OTP_InputOTPText2'), OTPText, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.sendKeys(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/SignUp_OTP_InputOTPText3'), OTPText, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.sendKeys(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/SignUp_OTP_InputOTPText4'), OTPText, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.sendKeys(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/SignUp_OTP_InputOTPText5'), OTPText, FailureHandling.CONTINUE_ON_FAILURE)
Mobile.sendKeys(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/SignUp_OTP_InputOTPText6'), OTPText, FailureHandling.CONTINUE_ON_FAILURE)