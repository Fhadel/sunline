import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.App
import org.sikuli.script.Pattern
import org.sikuli.script.Region
import org.sikuli.script.Screen;
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Initializing Driver for Run

WebUI.openBrowser("http://localhost:8084")

//Initializing variables
WebDriver wd = DriverFactory.getWebDriver()
WebDriverWait wait = new WebDriverWait(wd,10);
Screen s = new Screen();
wd.manage().window().maximize();
wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//Click Find Owner Button
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".nav > li:nth-child(3) > a:nth-child(1)")));
wd.findElement(By.cssSelector(".nav > li:nth-child(3) > a:nth-child(1)")).click();

//Sikulix Take Over
System.out.println("*** Login Sikuli ***");

//Enter Last Name Owner as Franklin
s.doubleClick("/Users/18055967/Automation/CustomKeywordLibrary/SiKuliX/textFieldPetClinic.png")
s.type("Franklin")
s.click("/Users/18055967/Automation/CustomKeywordLibrary/SiKuliX/FindOwnerBtn.png")

//Mark Area Owner Information
Pattern a = new Pattern("/Users/18055967/Automation/CustomKeywordLibrary/SiKuliX/OwnerInformationDetail.png")
Region reg = s.exists(a)

//Log All Text in Region Area Owner Information
String[] texts = reg.text().split(" ")
println(texts)

//Open App
myApp = App.open("Sublime Text")
s.paste(texts[0])






