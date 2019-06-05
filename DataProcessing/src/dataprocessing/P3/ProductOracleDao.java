package dataprocessing.P3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductOracleDao extends OracleBaseDao implements ProductDao {

	public List<Product> findAll() throws SQLException {
		OVChipkaartOracleDao kaartDao = new OVChipkaartOracleDao();
		
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<OVChipkaart> kaartList = kaartDao.findAll();
		
		for(OVChipkaart ov : kaartList) {
			System.out.println("Alle producten op kaart " + ov.getKaartnummer() + ":");
			
			for(Product p : ov.getProductenOpKaart()) {
				System.out.println(String.format("%s. %s. %s. prijs: %s",
						p.getProductNummer(), p.getProductNaam(), p.getBeschrijving(), p.getPrijs()));
				productList.add(p);
			}
		}
		System.out.println();
		return productList;
	}
	
	@Override
	public List<Product> findAllWithCards() throws SQLException {
		OVChipkaartOracleDao kaartDao = new OVChipkaartOracleDao();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ArrayList<Product> list = new ArrayList<Product>();
		
		String queryText = "SELECT * FROM product";
		ResultSet rs = stmt.executeQuery(queryText);
		
		while(rs.next()) {
			int productNummer = rs.getInt("productnummer");
			String productNaam = rs.getString("productnaam");
			String beschrijving = rs.getString("beschrijving");
			double prijs = rs.getDouble("prijs");
			
			Product p = new Product(productNummer, productNaam, beschrijving, prijs);
			p.setStaatOpKaarten(kaartDao.findByProduct(p));
			list.add(p);
		}
		
		for(Product p : list) {
			System.out.println("Alle kaarten met " + p.getProductNaam() + ":");
			
			for(OVChipkaart ov : p.getStaatOpKaarten()) {
				System.out.println(String.format("Kaartnummer: %s, Einddatum: %s, Klasse: %s, Saldo: %s",
						ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo()));
			}
		}
		System.out.println();
		
		rs.close();
		stmt.close();
		closeConnection();
		
		return list;
	}
	
	//Checks what products are activated on a card.
	@Override
	public ArrayList<Product> findByKaart(OVChipkaart kaart) throws SQLException {
		Connection conn = getConnection();
		ArrayList<Product> list = new ArrayList<Product>();
		
		String queryText = "SELECT p.productnummer, p.productnaam, p.beschrijving, p.prijs\r\n" + 
				"FROM product p, ov_chipkaart ov, ov_chipkaart_product ovp\r\n" + 
				"WHERE ov.kaartnummer = ovp.kaartnummer\r\n" + 
				"AND p.productnummer = ovp.productnummer\r\n" + 
				"AND ov.kaartnummer = ?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, kaart.getKaartnummer());
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int productNummer = rs.getInt("productnummer");
			String productNaam = rs.getString("productnaam");
			String beschrijving = rs.getString("beschrijving");
			double prijs = rs.getDouble("prijs");
			
			Product p = new Product(productNummer, productNaam, beschrijving, prijs);			
			list.add(p);
		}
		
		rs.close();
		pstmt.close();
		closeConnection();
		
		return list;
	}

	@Override
	public Product save(Product product) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "INSERT INTO product VALUES (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, product.getProductNummer());
		pstmt.setString(2, product.getProductNaam());
		pstmt.setString(3, product.getBeschrijving());
		pstmt.setDouble(4, product.getPrijs());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return product;
	}

	@Override
	public Product update(Product product) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "UPDATE product SET productnaam=?, beschrijving=?, prijs=? WHERE productnummer=?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setString(1, product.getProductNaam());
		pstmt.setString(2, product.getBeschrijving());
		pstmt.setDouble(3, product.getPrijs());
		pstmt.setInt(4, product.getProductNummer());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return product;
	}

	@Override
	public boolean delete(Product product) throws SQLException {
		try {
			Connection conn = getConnection();
			
			String queryText = "DELETE FROM product WHERE productnummer = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setInt(1, product.getProductNummer());
			pstmt.executeUpdate();
			
			pstmt.close();
			closeConnection();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
