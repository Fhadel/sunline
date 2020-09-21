import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

ArrayList HTTPHeaderProp = new ArrayList()

HTTPHeaderProp.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS, 'application/json'))
HTTPHeaderProp.add(new TestObjectProperty('BTPN-ApiKey', ConditionType.EQUALS, '7b65d95b-a144-49f3-a7a7-fc6aa9dc2030'))
HTTPHeaderProp.add(new TestObjectProperty('username', ConditionType.EQUALS, 'jamal'))
HTTPHeaderProp.add(new TestObjectProperty('referenceNo', ConditionType.EQUALS, '321421421521521'))
HTTPHeaderProp.add(new TestObjectProperty('source', ConditionType.EQUALS, 'lamongan'))
RequestObject get = new RequestObject('GET')

get.setRestUrl('https://appapisit01.dev.corp.btpn.co.id:19502/v01/dukcapil/match/ktp?nik=100002254814&name=NUR%20AFIFAH&dob=18051984&pob=SIDIKALANG')
get.setHttpHeaderProperties(HTTPHeaderProp)
get.setRestRequestMethod('GET')
ResponseObject respGet = WS.sendRequest(get)
WS.verifyResponseStatusCode(respGet, 200)
println(respGet.getResponseText())



