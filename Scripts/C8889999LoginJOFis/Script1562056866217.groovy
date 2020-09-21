import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
//WebUI.openBrowser('https://jofis-sit.apps.dev.corp.btpn.co.id/')
//
//WebUI.maximizeWindow()
//
//WebUI.click(findTestObject('Object Repository/JOFis/UsernameTextField'))
//
//WebUI.delay(5)

//CustomKeywords.'utilities.uploadFileRobot.multipleUpload'(findTestObject("Object Repository/JOFis/UsernameTextField"))
//WebUI.setText(findTestObject('Object Repository/JOFis/UsernameTextField'), 'OPTIMUS1')

//CustomKeywords.'utilities.uploadFileRobot.multipleUpload'(findTestObject('Object Repository/JOFis/PasswordTextField'))

WS.sendRequest(findTestObject('GET_TestRail_Section'))

//CustomKeywords.'utilities.uploadFileRobot.multiUpload2disb'(findTestObject('Object Repository/JOFis/PasswordTextField'), 'C:\\Users\\2019100375\\Documents\\Anggi\\Text File\\Disbursement\\DISB OMA\\ENDUSER_2019_09_04.txt.aes', 'C:\\Users\\2019100375\\Documents\\Anggi\\Text File\\Disbursement\\DISB OMA\\KENDARAAN_2019_09_04.txt.aes', 'C:\\Users\\2019100375\\Documents\\Anggi\\Text File\\Disbursement\\DISB OMA\\KONTRAK_2019_09_04.txt.aes', 'C:\\Users\\2019100375\\Documents\\Anggi\\Text File\\Disbursement\\DISB OMA\\PENGURUS_2019_09_04.txt.aes', 'C:\\Users\\2019100375\\Documents\\Anggi\\Text File\\Disbursement\\DISB OMA\\SLIK_2019_09_04.txt.aes' )

//WebUI.setText(findTestObject('Object Repository/JOFis/PasswordTextField'), text)
//
//WebUI.click(findTestObject('Object Repository/JOFis/BtnLogin'))
//
//WebUI.delay(3)
//
//WebUI.click(findTestObject('Object Repository/JOFis/taskListIcon'))
//
//WebUI.verifyMatch(WebUI.getText(findTestObject('JOFis/HomePage_IconUser_BtnIconUser')), ('.*' + Username) + '.*', true)
//
//WebUI.click(findTestObject('Object Repository/JOFis/HomePage_IconUser_BtnIconUser'))