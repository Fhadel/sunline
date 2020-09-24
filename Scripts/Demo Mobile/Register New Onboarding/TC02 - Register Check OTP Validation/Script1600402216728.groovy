import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling

import internal.GlobalVariable


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

/**
 * GET OTP Text from pop up modal
 */
String OTPText = Mobile.getText(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_OTPText'), 5)
println("========================"+OTPText)
String[] splitOTP = OTPText.split("")
println(splitOTP)
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_BtnOK'), 2)
Mobile.delay(2)

/**
 * Input OTP in text view by tapping numpad keyboard with INVALID OTP
 */
Mobile.tap(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_OTP_InputOTP'), 2)
for(int i=0; i<= splitOTP.size() - 1;i++){
	println(splitOTP[i])
	Mobile.tap(findTestObject('SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/OTP_KeyboardKey', [('keypad') : splitOTP[1]]), 2)
}
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/InputOTP/OTP_InvalidOTPMsg'), 2)

Mobile.delay(5)
Mobile.verifyElementExist(findTestObject('Object Repository/SiMobi/SignUp_Page/SignUp_OTPPage/SignUpPage_PIN_TitelPINText'), 2)
Mobile.closeApplication()