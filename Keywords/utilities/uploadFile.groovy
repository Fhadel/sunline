package utilities

import java.awt.List
import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.Clipboard
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

/**
 * Function for upload file in web.
 * @param browseBtn is a button that you click before popup window to select file.
 * @param filePath is a your path to file you want to upload e.g "/usr/id.txt" 
 */
public class uploadFileRobot {
	Robot robot = new Robot()
	@Keyword
	def uploadFile(TestObject browseBtn, String filePath) {

		WebUI.click(browseBtn)

		StringSelection ss = new StringSelection(filePath)
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)

		robot.keyPress(KeyEvent.VK_U)
		robot.keyPress(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_V)
		robot.keyRelease(KeyEvent.VK_CONTROL)
		robot.keyPress(KeyEvent.VK_ENTER)
		robot.keyRelease(KeyEvent.VK_ENTER)
	}

	@Keyword
	def multipleUpload(TestObject to){
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String base = ''
		for(int n = 0; n < GlobalVariable.text.size(); n++ ){
			String Path = "C/User/Documents/"
			base = base.concat(Path+GlobalVariable.text[n]+",")
		}
		base = base.substring(0, base.length()-2)
		println(base)
	}

	@Keyword
	def multiUpload2disb(TestObject to, dir1, dir2, dir3, dir4, dir5, dir6, dir7 ){
		String path1 = dir1;
		String path2 = dir2;
		String path3 = dir3;
		String path4 = dir4;
		String path5 = dir5;
		String path6 = dir6;
		String path7 = dir7;
		String finalpath = path1 + "\n" + path2 + "\n" + path3 + "\n" + path4 + "\n" + path5 + "\n" + path6 + "\n" + path7;
		println(to, finalpath)
		//WebUI.uploadFile(to, finalpath);
	}
}
