package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CustomKeyword {

	/* 
	 * This keyword is to generate random string
	 * Parameters : total length
	 * Creator : Raka Aditoro F - 8 March 2019
	 */
	@Keyword 
	public String generateRandomString(int length){
		String baseStringPool = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890'
		StringBuilder stringBuilder = new StringBuilder()
		Random random = new Random()
		while (stringBuilder.length() <= length) {
			int index = ((random.nextFloat() * baseStringPool.length()) as int)
			stringBuilder.append(baseStringPool.charAt(index))
		}
		String stringResult = stringBuilder.toString()
		println stringResult
		return stringResult
	}


	/*
	 * This keyword created to do automatic counter for integer
	 * Pre-requisite : Global Variable with name:'CounterVariable' type:'String' value: 'Welcome-0'
	 * This keyword will count 0 + 1 and; 0 from Welcome-0 and save it back into GlobalVariable.CounterVariable
	 * Creator : Raka Aditoro F - 15 March 2019 
	 */
	//@Keyword ------> uncommand this line to enable this custom keyword
	public void counter(){
		String base = GlobalVariable.CounterVariable
		String numberFromBase = base.substring(8, base.length())
		int next = numberFromBase.toInteger() + 1
		GlobalVariable.CounterVariable = ('Welcome-' + next)
	}

}
