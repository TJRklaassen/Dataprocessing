package dataprocessing.P2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDao extends OracleBaseDao implements ReizigerDao {
	public List<Reiziger> findAll() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		List<Reiziger> list = new ArrayList<Reiziger>();
		
		String queryText = "SELECT * FROM reiziger";
		ResultSet rs = stmt.executeQuery(queryText);
		
		while(rs.next()) {
			int reizigerID = rs.getInt("reizigerid");
			String voorletters = rs.getString("voorletters");
			String tussenvoegsel = rs.getString("tussenvoegsel");
			String achternaam = rs.getString("achternaam");
			Date geboortedatum = rs.getDate("gebortedatum");
			
			Reiziger r = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, geboortedatum);
			list.add(r);
		}
		
		rs.close();
		stmt.close();
		closeConnection();
		
		return list;
	}

	public List<Reiziger> findByGbdatum(String gbdatum) throws SQLException {
		Connection conn = getConnection();
		List<Reiziger> list = new ArrayList<Reiziger>();
		
		String queryText = "SELECT * FROM reiziger WHERE gebortedatum = ?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setDate(1, Date.valueOf(gbdatum));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int reizigerID = rs.getInt("reizigerid");
			String voorletters = rs.getString("voorletters");
			String tussenvoegsel = rs.getString("tussenvoegsel");
			String achternaam = rs.getString("achternaam");
			Date geboortedatum = rs.getDate("gebortedatum");
			
			Reiziger r = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, geboortedatum);
			list.add(r);
		}
		
		rs.close();
		pstmt.close();
		closeConnection();
		
		return list;
	}

	public Reiziger save(Reiziger reiziger) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "INSERT INTO reiziger VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, reiziger.getReizigerID());
		pstmt.setString(2, reiziger.getVoorletters());
		pstmt.setString(3, reiziger.getTussenvoegsel());
		pstmt.setString(4, reiziger.getAchternaam());
		pstmt.setDate(5, reiziger.getGbdatum());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return reiziger;
	}

	public Reiziger update(Reiziger reiziger) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "UPDATE reiziger SET voorletters=?, tussenvoegsel=?, achternaam=?, gebortedatum=?  WHERE reizigerid=?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setString(1, reiziger.getVoorletters());
		pstmt.setString(2, reiziger.getTussenvoegsel());
		pstmt.setString(3, reiziger.getAchternaam());
		pstmt.setDate(4, reiziger.getGbdatum());
		pstmt.setInt(5, reiziger.getReizigerID());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "DELETE FROM reiziger WHERE reizigerid = ?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, reiziger.getReizigerID());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return true;
	}
}
