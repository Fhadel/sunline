import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import internal.GlobalVariable as GlobalVariable

class Listener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		String tcName = testCaseContext.getTestCaseId()
		/*
		 * Activate these code if you want to screenshot all step in your test case
		 * CustomKeywords.'utilities.HighlightElement.enlightWebUiBuiltInKeywords'()
		 * CustomKeywords.'utilities.HighlightElement.enlightMobile'()
		 */
		GlobalVariable.TC_Name = tcName.replace("Test Cases/", "")
		CustomKeywords.'utilities.HighlightElement.enlightMobile'()
		//CustomKeywords.'utilities.HighlightElement.enlightWebUiBuiltInKeywords'()
		//CustomKeywords.'com.extension.reportportal.context.ReportPortalContext.captureScreenShotForReportportal'()
		//CustomKeywords.'utilities.HighlightElement.pandemicStep'()
		new File (RunConfiguration.getReportFolder()+"/"+GlobalVariable.TC_Name+"/")
		GlobalVariable.FinalScreenshotDir = RunConfiguration.getReportFolder()+"/"+GlobalVariable.TC_Name+"/"
		//CustomKeywords.'utilities.Phoenix.connectDB'('nursyah', 'nursyah')
		//addCase(testCaseContext)
		
	}
	
	def addCase(TestCaseContext testCaseContext){
		def slurper =  new groovy.json.JsonSlurper()
		def responseGetSuites = WS.sendRequest(findTestObject('GET_TestRail_Suites'))
		def suiteid = slurper.parseText(responseGetSuites.getResponseBodyContent())
		ResponseObject responseGetCases = WS.sendRequest(findTestObject("GET_TestRail_Case", [ ('suiteId') : '1014' ]))
		def caseId = slurper.parseText(responseGetCases.getResponseBodyContent())
		String[] id = caseId.id
		String[] tc_ids = testCaseContext.getTestCaseId().split("/")
		String prep = tc_ids[tc_ids.size() - 1]
		ArrayList<String> preps = prep.split(" ")
		String prepis = preps.pop()
		String replaceAllChars = preps.toString().replace(",", " ").replace("[", "").replace("]", "").replace("T", "")
		ArrayList<String> tc_final = replaceAllChars.split(" ")
//		String prep = tc_ids[tc_ids.length - 1]
//		String[] preps = prep.split(" ")
//		String[] tc_id = preps[0].split(" ")
//		String[] tc_final = tc_id[0].split(",")
		def value
		value = id.find { it == tc_final }
		if( value == null ){
			//Add TC
			def addTCTestRail = WS.sendRequest(findTestObject('POST_TestRail_AddCase', [('custom_step') : 'Automatically Generated from Katalon adding new Test Case']))
			print addTCTestRail
			def resultCaseId = slurper.parseText(addTCTestRail.getResponseBodyContent()).id
			println("Add TC With ID==========>C"+ resultCaseId)
			KeywordUtil.markPassed("TC Added with ID C"+resultCaseId)
		}else{
			KeywordUtil.markPassed("Already Have TC")
		}
	}
	
	/**
	 * Executes after every test case run.
	 * @param idTC is set to mandatory as testrail_tc_id in every test case variable.
	 * @param test rail URL is set in GlobalVariable urlTestRail 
	 * set your id and password in the service request Object Repository/POST_TestRail
	 * these listener will send result of your run to Test Rail
	 */
	//@AfterTestCase 
	def afterTestCase(TestCaseContext testCaseContext) {
		/*
		 * statusID is a parameter TestRail Result 1 for pass, 5 for failed
		 * tc_final is an array list for all test run id 
		 * tc_ids will get name of test case that contains Test Run ID TestRail and
		 * next process will extract that ID to be passed into TestRail POST_TestRail
		 *
		 */
		ArrayList<String> tc_ids = testCaseContext.getTestCaseId().split("/")
		String prep = tc_ids[tc_ids.size() - 1]
		ArrayList<String> preps = prep.split(" ")
		String prepis = preps.pop()
		String replaceAllChars = preps.toString().replace(",", " ").replace("[", "").replace("]", "").replace("T", "")
		ArrayList<String> tc_final = replaceAllChars.split(" ")
		def tc_result = testCaseContext.getTestCaseStatus()
		def statusID
		for (def n : (0 .. tc_final.size() - 1)) {
				if( tc_result == 'PASSED'){
					println tc_final[n]
					statusID='1'
					def responseWS = WS.sendRequest(findTestObject('POST_TestRail', [('urlTestRail'): GlobalVariable.urlTestRail, ('idTC'): tc_final[n].replace("T", ""), ('stsID'): statusID, ('comment'): testCaseContext.getTestCaseId() ]))
					if (responseWS.getStatusCode() == 200){
						KeywordUtil.markPassed("Test Case is PASSED will set the result in TestRail as PASSED")
					}else{
						KeywordUtil.markFailed("Test Case Result is Not Generated " + responseWS.getResponseText() + " Caused By :"+ responseWS.getStatusCode())
					}
				}
				else{
					statusID='5'
					def responseWS = WS.sendRequest(findTestObject('POST_TestRail', [('urlTestRail'): GlobalVariable.urlTestRail, ('idTC'): tc_final[n].replace("T", ""), ('stsID'): statusID, ('comment'): testCaseContext.getTestCaseId() + " " + testCaseContext.getMessage().replaceAll("\n", "\\\\\\n").replaceAll("\t"," ")]))
					if (responseWS.getStatusCode() == 200){
						KeywordUtil.markPassed("Test Case is FAILED will set the result in TestRail as FAILED")
					}else{
						KeywordUtil.markFailed("Test Case Result is Not Generated " + responseWS.getResponseText() + " Caused By :"+ responseWS.getStatusCode())
					}
				}
				
			}
		}
	//CustomKeywords.'utilities.Phoenix.closeDatabaseConnection'()
}
