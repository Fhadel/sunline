package utilities

import java.sql.Connection;
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

public class Phoenix {

	private static Connection connection = null;
	static final String conn = "jdbc:phoenix:thin:url=http://mtrdlkdev01.dev.corp.btpn.co.id:8765;serialization=PROTOBUF"
	//"jdbc:phoenix:thin:url=http://" + host + ":" + port + ";serialization=PROTOBUF"

	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */
	//Establishing a connection to the DataBase
	@Keyword
	def connectDB(String username, String password) {
		//Load driver class for your specific database type
		//String conn = "jdbc:phoenix:thin:url=http://" + host + ":" + port + ";serialization=PROTOBUF"
		//Class.forName("org.apache.phoenix.queryserver.client.Driver")
		//String connectionString = "jdbc:sqlite:" + dataFile
		if (connection != null && !connection.isClosed()) {
			println('connection already opened')
			connection.close()

		}else{
			KeywordUtil.logInfo("Connection to Database is Opened")
		}
		connection = DriverManager.getConnection(conn, username, password)
		return connection
	}
	/**
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */
	//Executing the constructed Query and Saving results in resultset
	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)

		return rs;
	}

	def merge(ResultSet rs, Map<String,Object> obj, String key){
		try {
			obj.put(key, rs.getObject(key));
		} catch(Exception e){
			//
		}

	}
	//Extract data from result object to map

	@Keyword
	def mapData(ResultSet rs, ArrayList<String> columName){

		java.util.List<Map<String, Object>> result = new ArrayList<>();

		while (rs.next()) {
			Map<String,Object> obj = new HashMap<>();
			for(String key : columName){
				merge(rs,obj,key)
			}
			result.add(obj)
		}
		return result
	}

	@Keyword
	def getData(String queryString, ArrayList<String> keys){
		Statement stm = connection.createStatement()
		java.util.List<Map<String, Object>> result = new ArrayList<>();
		ResultSet rs = stm.executeQuery(queryString)
		result = mapData(rs, keys)
		println("==================== "+result)
		return result
	}


	//Closing the connection
	@Keyword
	def closeDatabaseConnection() {
		if (connection != null && !connection.isClosed()) {
			connection.close()
			KeywordUtil.logInfo("Connection to Database Has Been Closed!")
		}
		connection = null
	}


	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param queryString a SQL statement
	 * @return single value result of SQL statement
	 */
	@Keyword
	def execute(String queryString) {
		Statement stm = connection.createStatement()
		def result = stm.executeUpdate(queryString)

		if ( result  == 1 ) {
			KeywordUtil.markPassed("QUERY SUCCESSFULLY FETCH")
		}else{
			KeywordUtil.markFailed("QUERY FAILED TO FETCH")
		}
		return result
	}

	/**
	 * Execute query with in open connection and close connection request
	 */
	@Keyword
	def  sqlQuery(String queryString, Map<String, String> database, ArrayList<String> keys){
		connectDB(database.host, database.dbName, database.port, database.username, database.password);
		println("connection passed")
		def dataQuery = getData(queryString, keys)
		closeDatabaseConnection()
		return dataQuery

	}
	/**
	 * Execute SQL Command for (Update/Delete/Insert)
	 */
	@Keyword
	def SqlCommand(String queryString, Map<String, String> database){
		connectDB(database.host, database.dbName, database.port, database.username, database.password);
		execute(queryString)
		closeDatabaseConnection()
	}
}
