import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.network.ProxyInformation
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
def slurper = new groovy.json.JsonSlurper()
//
//String body = '{ "id" : "36", "title" : "Mr", "firstName" : "Testing", "lastName" : "Phonebook", "phoneNumber" : "11223344" }'
//
ArrayList HTTPHeaderProp = new ArrayList()
HTTPHeaderProp.add(new TestObjectProperty("Content-Type", ConditionType.EQUALS, "application/json"))
//
RequestObject ro = new RequestObject("POST_PhoneBook")
  ro.setRestUrl("http://10.1.77.73:7819/RTCP/examples/phonebook/api/")
  ro.setHttpHeaderProperties(HTTPHeaderProp)
  ro.setRestRequestMethod("POST")
  ro.setBodyContent(new HttpTextBodyContent(body))
  
ResponseObject respObj = WS.sendRequest(ro)

def resultPOST = slurper.parseText(respObj.getResponseBodyContent())
def valuePOST = resultPOST.id
GlobalVariable.G_entriesId = valuePOST
println("--------------" + valuePOST)

//Session 4 Exercise
RequestObject get = new RequestObject("GET Phonebook")
get.setRestUrl("https://appapisit01.dev.corp.btpn.co.id:19502/v1/users/90012953461/account/limits")
//get.setRestUrl("http://10.1.77.73:7819/RTCP/examples/phonebook/api/"+GlobalVariable.G_entriesId+"")
get.setHttpHeaderProperties(HTTPHeaderProp)
get.setRestRequestMethod("GET")
ResponseObject respGet = WS.sendRequest(get)
//WS.verifyResponseStatusCode(respGet, 200)
println(respGet.getResponseText())


//ResponseObject response = WS.sendRequest(findTestObject('Competency Network/GETPhonebook By ID')) 
//def result = slurper.parseText(response.getResponseText())
//def value = result.entries.id[2]
////WS.verifyEqual(value, resultPOST.name)
//println("--------------" + value)



ProxyInformation proxyInfo = new ProxyInformation()
proxyInfo.setProxyServerAddress("localhost")
proxyInfo.setProxyServerPort(8001)
proxyInfo.setProxyOption(ProxyOption.MANUAL_CONFIG.toString())
proxyInfo.setProxyServerType(ProxyServerType.HTTP.toString())
requestObject.setProxy(proxyInfo)