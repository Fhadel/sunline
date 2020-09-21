
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.json.JSONObject

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager


def slurper = new groovy.json.JsonSlurper()


//Session 1 Exercise
//ResponseObject resultGetSes1 = WS.sendRequest(findTestObject('Competency Network/GETPhonebook By ID', [('id') : GlobalVariable.G_id ]))
//WS.verifyResponseStatusCode(resultGetSes1, 200)
//println("Answer Session 1 >>>>>>>>>> "+resultGetSes1.getResponseText())
//
//////Session 2 Exercise
//def result = slurper.parseText(resultGetSes1.getResponseText())
//def extractor = result.firstName
//WS.verifyEqual(extractor, "IBU")
//println("Answer Session 2 >>>>>>>>>> "+extractor)

//Session 3 Exercise
long startTime = System.currentTimeMillis()
int i = 0
//while( startTime < startTime+10000 ){
//	def resultPost = WS.sendRequest(findTestObject("Competency Network/POST Phonebook")).getResponseBodyContent()
//	def postId = slurper.parseText(resultPost)
//	def resultGet = WS.sendRequest(findTestObject('Competency Network/GETPhonebook By ID', [('id') : postId.id ]))
//	def getId = slurper.parseText(resultGet.getResponseBodyContent())
//	println(resultGet.responseBodyContent)
//	WS.verifyEqual(postId.firstName, getId.firstName)
//}
////Delete all record phonebook on the DB
def param1 = WS.sendRequest(findTestObject('Competency Network/GETPhonebook')).getResponseBodyContent()
def params = slurper.parseText(param1).entries.size
println(params)
while (startTime < (startTime + 2000)) {
    if (i != params) {
        def ids = WS.sendRequest(findTestObject('Competency Network/GETPhonebook')).getResponseBodyContent()
        def values = slurper.parseText(ids)
        def resultId = values.entries[0].id
        println(resultId)
        WS.sendRequest(findTestObject('Competency Network/Delete Phonebook', [('id') : resultId]))
        println(System.currentTimeMillis())
    } else {
        break
    }
}



