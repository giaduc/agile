package common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConn {

	private static final Logger LOGGER = LogManager.getLogger(DBConn.class);
	
	private static Connection conn;
	private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	// private static final String CLASS_NAME =
	// "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:mysql://localhost/agile_ahihi?useSSL=false";
	// private static final String URL =
	// "jdbc:sqlserver://localhost:1433;databaseName=QLSV";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "1111";

	public static Connection getconnection() {
		try {
			Class.forName(CLASS_NAME);
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			LOGGER.debug("Connect successfully.");
		} catch (ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}

		return conn;
	}

	/**
	 * Test only
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DBConn.getconnection();
	}
}
