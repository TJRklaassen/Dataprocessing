package dataprocessing.P3;

import java.sql.SQLException;

public class Main {
	private static ProductOracleDao productDao = new ProductOracleDao();
	private static OVChipkaartOracleDao kaartDao = new OVChipkaartOracleDao();
	
	public static void main(String[] arg) throws SQLException {
		
		productDao.findAll();
		System.out.println();
		productDao.findAllWithCards();
		
		//De rest is allemaal het testen van de standaard methodes die hetzelfde werkten als bij Reiziger en OV-Chipkaart
		//Testen of save() en addProductToKaart() werken
		System.out.println("save() test:");
		OVChipkaart ov1 = kaartDao.findByKaartnummer(35283);
		Product p1 = new Product(7, "Dagkaart 1e klas", "Een hele dag onbeperkt reizen met de trein in 1e klas.", 72.50);
		productDao.save(p1);
		kaartDao.addProductToKaart(9, ov1, p1);
		productDao.findAllWithCards();
		
		//Testen of delete() en deleteProductFromKaart() werken
		System.out.println("delete() test:");
		kaartDao.deleteProductFromKaart(ov1, p1);
		productDao.delete(p1);
		productDao.findAllWithCards();
		
		//Testen of update() werkt
		System.out.println("update() test:");
		Product p2 = new Product(5, "Railrunner 12-", "Voordelig reizen voor kinderen onder de 12.", 3);
		productDao.update(p2);
		productDao.findAllWithCards();
		
		//Herstelt oude waarden om later opnieuw update() te kunnen testen
		p2 = new Product(5, "Railrunner", "Voordelig reizen voor kinderen", 2.50);
		productDao.update(p2);
	}
	
	public static void printFindByKaart(OVChipkaart kaart) throws SQLException {
	//Test findByKaart() en relatie tussen product en ov_chipkaart
		System.out.println("Alle producten die op kaart met kaartnummer "+kaart.getKaartnummer()+" zitten:");
		for(Product p : productDao.findByKaart(kaart)){
			System.out.println(String.format("%s. %s. %s > prijs: %s",
				p.getProductNummer(), p.getProductNaam(), p.getBeschrijving(), p.getPrijs()));
		}
		System.out.println();
	}
}