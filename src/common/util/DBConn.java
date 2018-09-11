package common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	private static Connection conn;
	private static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
//	private static final String CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:mysql://localhost/agile_ahihi?useSSL=false";
//	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "1111";

	public static Connection getconnection() {
		try {
			Class.forName(CLASS_NAME);
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("Connect successfully.");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			System.out.println("Can't connect.");
		}

		return conn;
	}

	public static void main(String[] args) {
		DBConn.getconnection();
	}
}
