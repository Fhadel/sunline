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
 * Step fill field and go to OTP Page
 */
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_MobileNumber'), "082112370408", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Full Name'), "Fhadel Achmad Fadillah", 2)
Mobile.setText(findTestObject('SiMobi/SignUp_Page/SignUpPage_TxtField_Email Address'), "fhadelfadillah@gmail.com", 2)
Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_RadioBtn_Agreement'), 2)
Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUpPage_Btn_Next'), 2)

/**
 * Verify pop up OTP pin
 */
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_BtnOK'), 2)
String textResend = Mobile.getText(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_ResendOTP'), 2)

while(textResend.contains("Resend OTP")){
	Mobile.delay(2)
}

/**
 * Click RESEND OTP to get new OTP
 */
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_ResendOTPNew'), 2)
Mobile.delay(3)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_BtnOK'), 2)
String OTPText2 = Mobile.getText(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_OTPText'), 5)
println("========================"+OTPText2)
String[] splitOTP2 = OTPText2.split("")
println(splitOTP2)
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_BtnOK'), 2)
Mobile.delay(2)
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_InputOTP'), 2)
Mobile.delay(2)

/**
 * Input OTP in text view by tapping numpad keyboard with VALID OTP
 */
for(int i=0; i<= splitOTP2.size() - 1;i++){
	println(splitOTP2[i])
	Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/OTP_KeyboardKey', [('keypad') : splitOTP2[i]]), 2)
}

Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_PIN_TitelPINText'), 2)
Mobile.closeApplication()
