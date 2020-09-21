import com.kms.katalon.core.testdata.InternalData
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.testdata.TestData as TestData


//Data Tables
//DBData data = findTestData('DB_Los Martin')
//data.query = data.query.replace("'APPID'", GlobalVariable.G_AppID)
//data.fetchedData = data.fetchData()
//for (def index : (0..data.getRowNumbers() - 1)){
//	//Set Text using data from test data
//	//"User" is a coloumn name in test data
//	//index is a number that will autoincrease from FOR LOOP above
//	println(data.getValue(2, 1))
//	assert data.getValue(2, 1) == 1
//}

InternalData datax = findTestData("Data Dummy")
for (def index : (0..datax.getRowNumbers() - 1)){
//	//Upsert 1st Table
	CustomKeywords.'utilities.Phoenix.execute'("UPSERT INTO EDS_UAT.LENDING_AGGREGATE(CRN_NUMBER_TEXT, CNT_DPD_30_L6M, MAX_COLL_L12M)VALUES('"+ datax.internallyGetValue("Data 1", index) +"',0,1)")
	
//	//Upsert 2nd Table
//	CustomKeywords.'utilities.Phoenix.execute'("UPSERT INTO EDS_UAT.LENDING_AGGREGATE(CRN_NUMBER_TEXT, CNT_DPD_30_L6M, MAX_COLL_L12M)VALUES('"+ datax.internallyGetValue("Data 2", index) +"',0,1)")
//	
//	//Upsert 3rd Table
//	CustomKeywords.'utilities.Phoenix.execute'("UPSERT INTO EDS_UAT.LENDING_AGGREGATE(CRN_NUMBER_TEXT, CNT_DPD_30_L6M, MAX_COLL_L12M)VALUES('"+ datax.internallyGetValue("Data 3", index) +"',0,1)")
//	
//	//Upsert 4th Table
//	CustomKeywords.'utilities.Phoenix.execute'("UPSERT INTO EDS_UAT.LENDING_AGGREGATE(CRN_NUMBER_TEXT, CNT_DPD_30_L6M, MAX_COLL_L12M)VALUES('"+ datax.internallyGetValue("Data 4", index) +"',0,1)")
//	
//	//Upsert 5th Table
//	CustomKeywords.'utilities.Phoenix.execute'("UPSERT INTO EDS_UAT.LENDING_AGGREGATE(CRN_NUMBER_TEXT, CNT_DPD_30_L6M, MAX_COLL_L12M)VALUES('"+ datax.internallyGetValue("Data 5", index) +"',0,1)")
//	
//	//Upsert 6th Table
//	CustomKeywords.'utilities.Phoenix.execute'("UPSERT INTO EDS_UAT.LENDING_AGGREGATE(CRN_NUMBER_TEXT, CNT_DPD_30_L6M, MAX_COLL_L12M)VALUES('"+ datax.internallyGetValue("Data 6", index) +"',0,1)")
//	
//	//Upsert 7st Table
//	CustomKeywords.'utilities.Phoenix.execute'("UPSERT INTO EDS_UAT.LENDING_AGGREGATE(CRN_NUMBER_TEXT, CNT_DPD_30_L6M, MAX_COLL_L12M)VALUES('"+ datax.internallyGetValue("Data 7", index) +"',0,1)")
	
}




