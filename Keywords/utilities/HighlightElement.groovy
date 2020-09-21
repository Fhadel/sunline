package utilities

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.extension.reportportal.context.ReportPortalContext
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/* Read this before you setup the keyword 
 * These Keywords function for screenshot based on what step do you want to take screenshot after it triggered
 * How to use : 
 * 1. Place this keyword code in "Keywords" folder with package name "utlities"
 * 2. Setup listener BeforeTestCase for triggered the keyword before testcase start
 * 3. Create GlobalVariable for "TC_Name" value empty string, "FinalScreenshotDir" value empty string, "Step" value "Step - 0"
 */

public class HighlightElement {

	@Keyword
	public static final on(TestObject testObject) {
		return examine(DriverFactory.getWebDriver(), testObject, OutlineStyle.TOUCHED)
	}
	
	public static final onMobile(TestObject testObject) {
		return examine(MobileDriverFactory.getDriver(), testObject, OutlineStyle.TOUCHED)
	}

	private static final enum OutlineStyle {
		TOUCHED('dashed hotpink');
		String value;
		OutlineStyle(String value) {
			this.value = value
		}
	}

	private final static List<WebElement> examine(WebDriver driver, TestObject testObject, OutlineStyle outlineStyle) {
		List<WebElement> elements
		try {
			elements = WebUiCommonHelper.findWebElements(testObject, 1);  // timeout should be minimum
			for (WebElement element : elements) {
				JavascriptExecutor js = (JavascriptExecutor) driver
				js.executeScript(
						"arguments[0].setAttribute('style', 'outline: " +
						"${outlineStyle.value};');",
						element);
			}
		} catch (Exception e) {
			;
			// Here we should ignore the Exception silently.
			// But why? --- because WebUI.click() will fall down into here.
		} finally {
			return elements
		}
	}


	private static void influenceOff(TestObject testObject) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement element = WebUiCommonHelper.findWebElement(testObject, 20);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'outline: transparent;');",element);
		}
		catch (Exception e) {
			e.printStackTrace()
		}
	}

	private static List<String> influencedKeywords = [
		'verifyElementPresent',
		'verifyEqual',
		'verifyElementVisible',
		'verifyElementText',
		'setText',
		'setEncryptedText',
		'selectOptionByValue',
		'selectOptionByIndex',
		'sendRequest'
	]

	private static List<String> influencedKeywordsWeb = [
		'verifyElementPresent',
		'verifyEqual',
		'verifyElementVisible',
		'verifyElementText',
		'setText',
		'setEncryptedText',
		'selectOptionByValue',
		'selectOptionByIndex'
	]

	private static List<String> influencedKeywordsMobile = [
		'verifyElementExist',
		'setText'
	]


	/**
	 * change some of methods of WebUiBuiltInKeywords so that they call HighlightElement.on(testObject)
	 * before invoking their original method body.
	 *
	 * http://docs.groovy-lang.org/latest/html/documentation/core-metaprogramming.html#metaprogramming
	 */

	public static String getScreenshotName(TestObject testObject){
		String base = testObject
		String removeQuote = base.replace("'", "")
		String [] split1 = removeQuote.split("/")
		int z = split1.size()
		String screenshotFileName = split1[z-2]+" - "+split1.last()
		return screenshotFileName
	}

	public static void screenshotAftermethodWeb(String action, TestObject testObject){
		String a = GlobalVariable.Step
		String [] b = a.split("-")
		int c = b[1].toInteger()
		int d = c + 1
		GlobalVariable.Step = 'Step-'+d
		HighlightElement.on(testObject)
		WebUI.takeScreenshot(GlobalVariable.FinalScreenshotDir+GlobalVariable.Step+". "+action.toLowerCase().capitalize()+" - "+getScreenshotName(testObject)+".png")
		//influenceOff(testObject)
	}

	public static void getStepName(String action, TestObject testObject){
		String a = GlobalVariable.Step
		String [] b = a.split("-")
		int c = b[1].toInteger()
		int d = c + 1
		GlobalVariable.Step = 'Step-'+d
		//HighlightElement.on(testObject)
		String Step = GlobalVariable.Step+". "+action.toLowerCase().capitalize()+" - "+getScreenshotName(testObject)
		println("+++++++++++++"+Step)
	}

	public static void screenshotAftermethodMobile(String action, TestObject testObject){
		String a = GlobalVariable.Step
		String [] b = a.split("-")
		int c = b[1].toInteger()
		int d = c + 1
		GlobalVariable.Step = 'Step-'+d
		HighlightElement.onMobile(testObject)
		println(GlobalVariable.Step)
		Mobile.takeScreenshot(GlobalVariable.FinalScreenshotDir+GlobalVariable.Step+". "+action.toLowerCase().capitalize()+" - "+getScreenshotName(testObject)+".png")
		//influenceOff(testObject)
	}

	private static final boolean isHighlightingCapable(List<String> highlightingCapableKeywords, String keywordName, Object args) {
		return (keywordName in highlightingCapableKeywords && hasTestObjectAs1stArg(args))
	}

	@Keyword
	public static final void enlightWebUiBuiltInKeywords() {
		List<String> additionalKeywords = []
		enlightWebUiBuiltInKeywords(additionalKeywords)
	}

	@Keyword
	public static final void enlightWebUiBuiltInKeywords(List<String> additionalKeywords) {
		influencedKeywordsWeb.add(additionalKeywords)
		WebUI.metaClass.'static'.invokeMethod = { String keywordName, Object args ->
			if (isHighlightingCapable(influencedKeywordsWeb, keywordName, args)) {
				TestObject to = (TestObject)args[0]
				HighlightElement.on(to)
				screenshotAftermethodWeb(keywordName,to)
				ReportPortalContext.captureScreenShotForReportportal()
				influenceOff(to)
			}
			MetaMethod metaMethod = delegate.metaClass.getMetaMethod(keywordName, args)
			if (metaMethod != null) {
				return metaMethod.invoke(delegate, args)
			} else {
				throw new IllegalArgumentException("failed to find delegate.metaCLass.metaMethod(${keywordName},${args}).")
			}
		}
	}

	@Keyword
	public static final void enlightMobile(List<String> additionalKeywords) {
		influencedKeywordsMobile.add(additionalKeywords)
		Mobile.metaClass.'static'.invokeMethod = { String keywordName, Object args ->
			if (isHighlightingCapable(influencedKeywordsMobile, keywordName, args)) {
				TestObject to = (TestObject)args[0]
				HighlightElement.onMobile(to)
				screenshotAftermethodMobile(keywordName,to)
			}
			MetaMethod metaMethod = delegate.metaClass.getMetaMethod(keywordName, args)
			if (metaMethod != null) {
				return metaMethod.invoke(delegate, args)
			} else {
				throw new IllegalArgumentException("failed to find delegate.metaCLass.metaMethod(${keywordName},${args}).")
			}
		}
	}


	@Keyword
	public static void pandemicStep(List<String> additionalKeywords) {
		influencedKeywordsMobile.add(additionalKeywords)
		WSBuiltInKeywords.metaClass.'static'.invokeMethod = { String keywordName, Object args ->
			if (isHighlightingCapable(influencedKeywordsMobile, keywordName, args)) {
				TestObject to = (TestObject)args[0]
				HighlightElement.on(to)
				getStepName(keywordName, to)
			}
			MetaMethod metaMethod = delegate.metaClass.getMetaMethod(keywordName, args)
			if (metaMethod != null) {
				return metaMethod.invoke(delegate, args)
			} else {
				throw new IllegalArgumentException("failed to find delegate.metaCLass.metaMethod(${keywordName},${args}).")
			}
		}
	}

	private static final boolean hasTestObjectAs1stArg(Object args) {
		Class clazz = args.getClass()
		if (clazz.isArray()) {
			Object[] objects = (Object[])args
			if (objects.length > 0) {
				return (args[0] instanceof TestObject)
			} else
				return false
		} else
			return false
	}

}
