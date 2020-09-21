//package utilities
//
//import java.awt.List
//import java.sql.DriverManager
//import java.sql.ResultSet
//import java.sql.Statement
//
//import javax.swing.tree.RowMapper
//
//import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return
//
//import com.kms.katalon.core.annotation.Keyword
//import com.mysql.jdbc.Connection
//
//public class mySql {
//	private static Connection connection = null;
//	/**
//	 * Open and return a connection to database
//	 * @param dataFile absolute file path
//	 * @return an instance of java.sql.Connection
//	 */
//	//Establishing a connection to the DataBase
//	@Keyword
//	def connectDB(String host, String dbname, String port, String username, String password) {
//		//Load driver class for your specific database type
//		String conn = "jdbc:mysql://" + host + ":" + port + "/" + dbname
//		//Class.forName("org.sqlite.JDBC")
//		//String connectionString = "jdbc:sqlite:" + dataFile
//		if (connection != null && !connection.isClosed()) {
//			println('connection already opened')
//			connection.close()
//
//		}
//		connection = DriverManager.getConnection(conn, username, password)
//		return connection
//	}
//	/**
//	 * execute a SQL query on database
//	 * @param queryString SQL query string
//	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
//	 */
//	//Executing the constructed Query and Saving results in resultset
//	@Keyword
//	def executeQuery(String queryString) {
//		Statement stm = connection.createStatement()
//		ResultSet rs = stm.executeQuery(queryString)
//
//		return rs;
//	}
//
//	def merge(ResultSet rs, Map<String,Object> obj, String key){
//		try {
//			obj.put(key, rs.getObject(key));
//		} catch(Exception e){
//			//
//		}
//
//	}
//	//Extract data from result object to map
//
//	@Keyword
//	def mapData(ResultSet rs, ArrayList<String> columName){
//
//		java.util.List<Map<String, Object>> result = new ArrayList<>();
//
//		while (rs.next()) {
//			Map<String,Object> obj = new HashMap<>();
//			for(String key : columName){
//				merge(rs,obj,key)
//			}
//			result.add(obj)
//		}
//		return result
//	}
//
//	@Keyword
//	def getData(String queryString, ArrayList<String> keys){
//		Statement stm = connection.createStatement()
//		java.util.List<Map<String, Object>> result = new ArrayList<>();
//		ResultSet rs = stm.executeQuery(queryString)
//
//		result = mapData(rs, keys)
//
//		return result
//	}
//
//
//	//Closing the connection
//	@Keyword
//	def closeDatabaseConnection() {
//		if (connection != null && !connection.isClosed()) {
//			connection.close()
//		}
//		connection = null
//	}
//
//
//	/**
//	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
//	 * @param queryString a SQL statement
//	 * @return single value result of SQL statement
//	 */
//	@Keyword
//	def execute(String queryString) {
//		Statement stm = connection.createStatement()
//		boolean result = stm.execute(queryString)
//		return result
//	}
//
//	/**
//	 * Execute query with in open connection and close connection request
//	 */
//	@Keyword
//	def  sqlQuery(String queryString, Map<String, String> database, ArrayList<String> keys){
//
//		connectDB(database.host, database.dbName, database.port, database.username, database.password);
//		def dataQuery = getData(queryString, keys)
//		closeDatabaseConnection()
//
//		return dataQuery
//
//	}
//}
