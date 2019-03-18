package javacodegeeks.dbcp.connection.pooling.example.util;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataBaseUtility {
	private static BasicDataSource basicDataSource;
	
	public static BasicDataSource getBasicDataSsource() {
		if(basicDataSource == null) {
			basicDataSource = new BasicDataSource();
			basicDataSource.setUrl("jdbc:h2:~/test");
			basicDataSource.setUsername("sa");
			
			// Sets the minimum number of connection object that are to be kept alive in the pool.
			basicDataSource.setMinIdle(5);
			
			//Sets the maximum number of Idle connections in the pool. 
			// If the total number of connections in the pool exceeds this number, 
			// the extra connections are released as soon as they are returned to the connection pool.
			basicDataSource.setMaxIdle(10);
			
			//The maximum number of the java.sql.PreparedStatement that can be cached.
			// The PreparedStatement cache is associated with each connection object. 
			//When we create another similar PreparedStatement object, 
			//a cached preparedstatement object is returned. 
			//This reduces the time spent by the Database server in parsing the new SQL Query
			// again thus improving the overall application throughput.
			basicDataSource.setMaxOpenPreparedStatements(100);
		}
		
		return basicDataSource;
	}
}
