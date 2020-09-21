package mobile

import org.openqa.selenium.By

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver

public class CustomKeywordMobile {

	/*
	 * This keyword is to tap on mobile list
	 * Parameter 1 : Element class. E.g: android.view.textview
	 * Parameter 2 : Selected list
	 * Creator : Raka Aditoro F - 15 March 2019 
	 */
	//@Keyword ------> uncommand this line to enable this custom keyword
	public void selectListMobile(String classElement, String expectedValue){
		AndroidDriver driver = MobileDriverFactory.getDriver()
		MobileElement ele = driver.findElement(By.xpath(('//'+classElement+'[contains(@text, \'' + expectedValue) + '\')]'))
		ele.click()
	}
}
