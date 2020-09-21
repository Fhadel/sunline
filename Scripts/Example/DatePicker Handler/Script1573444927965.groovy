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

WebUI.openBrowser('https://bes-sit.apps.dev.corp.btpn.co.id/#/home/loan')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/ByCss', [('css') : '#bes-login-username']), 'bes.sam.sit005')

WebUI.setText(findTestObject('Object Repository/ByCss', [('css') : '#bes-login-password']), 'P@ssw0rd')

WebUI.click(findTestObject('Object Repository/ByCss', [('css') : '#btn_login']))

WebUI.delay(5)

//WebUI.click(findTestObject('Object Repository/ByCss', [('css') : '#ipt-valueDate > span > input']))

CustomKeywords.'utilities.DatePicker.datePicker'('22 Mei 2019')

