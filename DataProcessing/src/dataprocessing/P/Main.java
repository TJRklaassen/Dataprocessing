package dataprocessing.P;

import java.sql.*;

public class Main {
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
	private static final String DB_USER = "TIP";
	private static final String DB_PASS = "db";
	private static Connection conn;
	
	public static void main(String[] args) throws SQLException{
		
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		Statement stmt = conn.createStatement();
		
		String queryText = "SELECT * FROM medewerkers";
		ResultSet rs = stmt.executeQuery(queryText);
		
		int id;
		String naam;
		while (rs.next()) {   
			id = rs.getInt("mnr");	
			naam = rs.getString("naam");
			System.out.println(id + ", " + naam);
		}

		rs.close();
		stmt.close();
		conn.close();
	}
}