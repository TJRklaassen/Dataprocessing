package dataprocessing.P2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDao extends OracleBaseDao implements OVChipkaartDao{
	private ArrayList<OVChipkaart> kaartLijst = new ArrayList<OVChipkaart>();
	
	public List<OVChipkaart> findAll() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		List<OVChipkaart> list = new ArrayList<OVChipkaart>();
		
		String queryText = "SELECT * FROM ov_chipkaart";
		ResultSet rs = stmt.executeQuery(queryText);
		
		while(rs.next()) {
			int kaartnummer = rs.getInt("kaartnummer");
			Date geldigtot = rs.getDate("geldigtot");
			int klasse = rs.getInt("klasse");
			double saldo = rs.getDouble("saldo");
			int reizigerid = rs.getInt("reizigerid");
			
			String queryText2 = "SELECT * FROM reiziger WHERE reizigerid = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText2);
			pstmt.setInt(1, reizigerid);
			ResultSet rs2 = pstmt.executeQuery();
			
			rs2.next();
			int reizigerID = rs2.getInt("reizigerid");
			String voorletters = rs2.getString("voorletters");
			String tussenvoegsel = rs2.getString("tussenvoegsel");
			String achternaam = rs2.getString("achternaam");
			Date geboortedatum = rs2.getDate("gebortedatum");
			Reiziger r = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, geboortedatum);
			
			rs2.close();
			pstmt.close();
			
			OVChipkaart ov = new OVChipkaart(kaartnummer, geldigtot, klasse, saldo, r);
			list.add(ov);
		}
		
		rs.close();
		stmt.close();
		closeConnection();
		
		return list;
	}

	public List<OVChipkaart> findByKaartnummer(int nummer) throws SQLException {
		Connection conn = getConnection();
		List<OVChipkaart> list = new ArrayList<OVChipkaart>();
		
		String queryText = "SELECT * FROM ov_chipkaart WHERE kaartnummer = ?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, nummer);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int kaartnummer = rs.getInt("kaartnummer");
			Date geldigtot = rs.getDate("geldigtot");
			int klasse = rs.getInt("klasse");
			double saldo = rs.getDouble("saldo");
			int reizigerid = rs.getInt("reizigerid");
			
			String queryText2 = "SELECT * FROM reiziger WHERE reizigerid = ?";
			PreparedStatement pstmt2 = conn.prepareStatement(queryText2);
			pstmt2.setInt(1, reizigerid);
			ResultSet rs2 = pstmt2.executeQuery();
			
			rs2.next();
			int reizigerID = rs2.getInt("reizigerid");
			String voorletters = rs2.getString("voorletters");
			String tussenvoegsel = rs2.getString("tussenvoegsel");
			String achternaam = rs2.getString("achternaam");
			Date geboortedatum = rs2.getDate("gebortedatum");
			Reiziger r = new Reiziger(reizigerID, voorletters, tussenvoegsel, achternaam, geboortedatum);
			
			rs2.close();
			pstmt2.close();
			
			OVChipkaart ov = new OVChipkaart(kaartnummer, geldigtot, klasse, saldo, r);
			list.add(ov);
		}
		
		rs.close();
		pstmt.close();
		closeConnection();
		
		return list;
	}
	
	public List<OVChipkaart> findByKaarthouder(Reiziger kaarthouder) throws SQLException {
		Connection conn = getConnection();
		List<OVChipkaart> list = new ArrayList<OVChipkaart>();
		
		String queryText = "SELECT * FROM ov_chipkaart WHERE reizigerid = ?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, kaarthouder.getReizigerID());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int kaartnummer = rs.getInt("kaartnummer");
			Date geldigtot = rs.getDate("geldigtot");
			int klasse = rs.getInt("klasse");
			double saldo = rs.getDouble("saldo");
			
			OVChipkaart ov = new OVChipkaart(kaartnummer, geldigtot, klasse, saldo, kaarthouder);
			list.add(ov);
		}
		
		rs.close();
		pstmt.close();
		closeConnection();
		
		return list;
	}

	public OVChipkaart save(OVChipkaart kaart) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "INSERT INTO ov_chipkaart VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, kaart.getKaartnummer());
		pstmt.setDate(2, kaart.getGeldigTot());
		pstmt.setInt(3, kaart.getKlasse());
		pstmt.setDouble(4, kaart.getSaldo());
		pstmt.setInt(5, kaart.getKaarthouder().getReizigerID());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return kaart;
	}

	public OVChipkaart update(OVChipkaart kaart) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "UPDATE ov_chipkaart SET geldigtot=?, klasse=?, saldo=?, reizigerid=?  WHERE kaartnummer=?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setDate(1, kaart.getGeldigTot());
		pstmt.setInt(2, kaart.getKlasse());
		pstmt.setDouble(3, kaart.getSaldo());
		pstmt.setInt(4, kaart.getKaarthouder().getReizigerID());
		pstmt.setInt(5, kaart.getKaartnummer());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return kaart;
	}

	public boolean delete(OVChipkaart kaart) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "DELETE FROM ov_chipkaart WHERE kaartnummer = ?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, kaart.getKaartnummer());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return true;
	}
}