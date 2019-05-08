package dataprocessing.P2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDao extends OracleBaseDao implements OVChipkaartDao{
	
	public List<OVChipkaart> findAll() throws SQLException {
		ReizigerOracleDao reizigerDao = new ReizigerOracleDao();
		
		ArrayList<OVChipkaart> kaartList = new ArrayList<OVChipkaart>();
		ArrayList<Reiziger> reizigerList = reizigerDao.findAll();
		
		for(Reiziger r : reizigerList) {
			for(OVChipkaart k : r.getKaarten()) {
				kaartList.add(k);
			}
		}
		return kaartList;
	}
	
	public List<OVChipkaart> findByKaartnummer(int nummer) throws SQLException {
		ReizigerOracleDao reizigerDao = new ReizigerOracleDao();
		
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
			
			Reiziger reiziger = reizigerDao.findByReizigerID(reizigerid);
			
			OVChipkaart ov = new OVChipkaart(kaartnummer, geldigtot, klasse, saldo, reiziger);
			list.add(ov);
		}
		
		rs.close();
		pstmt.close();
		closeConnection();
		
		return list;
	}
	
	public ArrayList<OVChipkaart> findByKaarthouder(Reiziger kaarthouder) throws SQLException {
		Connection conn = getConnection();
		ArrayList<OVChipkaart> list = new ArrayList<OVChipkaart>();
		
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
		try {
			Connection conn = getConnection();
			
			String queryText = "DELETE FROM ov_chipkaart WHERE kaartnummer = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setInt(1, kaart.getKaartnummer());
			pstmt.executeUpdate();
			
			pstmt.close();
			closeConnection();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}