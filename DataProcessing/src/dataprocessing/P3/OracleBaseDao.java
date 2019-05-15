package dataprocessing.P3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	private static final String DB_USER = "PERSISTENCE";
	private static final String DB_PASS = "db";
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}
}
