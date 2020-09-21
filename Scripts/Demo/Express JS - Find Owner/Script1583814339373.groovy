import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def slurper = new groovy.json.JsonSlurper()

RequestObject ro = new RequestObject("GET_AllOwner")
ro.setRestUrl("http://10.1.77.75:3000/api/owner/")
ro.setRestRequestMethod("GET")

ResponseObject respObj = WS.sendRequest(ro)
responseObject = slurper.parseText(respObj.getResponseBodyContent()).response.firstName[1]
println responseObject
WS.verifyResponseStatusCode(respObj, 200)
