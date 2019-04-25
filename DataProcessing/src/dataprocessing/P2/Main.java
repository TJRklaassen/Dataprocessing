package dataprocessing.P2;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
	private static ReizigerOracleDao reizigerDao = new ReizigerOracleDao();
	private static OVChipkaartOracleDao kaartDao = new OVChipkaartOracleDao();
	
	public static void main(String[] arg) throws SQLException {
		//Testen of findAll() werkt
		printFindAll();
		
		//Testen of save() en findByGbdatum() werken
		Reiziger r1 = new Reiziger(6, "TJR", null, "Klaassen", Date.valueOf("2002-10-22"));
		reizigerDao.save(r1);
		printFindByGbdatum("2002-10-22");
		
		//Testen of delete() werkt
		reizigerDao.delete(r1);
		printFindByGbdatum("2002-10-22");
		
		//Testen of update() werkt
		Reiziger r2 = new Reiziger(2, "K", null, "Jansen", Date.valueOf("2001-10-22"));
		reizigerDao.update(r2);
		printFindByGbdatum("2001-10-22");
		printFindByGbdatum("2002-10-22");
		
		//Herstelt oude waarden om later opnieuw update() te kunnen testen
		r2 = new Reiziger(2, "B", "van", "Rijn", Date.valueOf("2002-10-22"));
		reizigerDao.update(r2);
	}
	
	//Methode om de lijst van findAll() duidelijk uit te printen
	public static void printFindAll() throws SQLException {
		for(Reiziger r : reizigerDao.findAll()) {
			if(r.getTussenvoegsel() == null) {
				System.out.println(String.format("%s, %s %s, %s",
						r.getReizigerID(), r.getVoorletters(), r.getAchternaam(), r.getGbdatum()));
			} else {
				System.out.println(String.format("%s, %s %s %s, %s",
						r.getReizigerID(), r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam(), r.getGbdatum()));
			}
		}
		System.out.println();
	}
	
	//Methode om de lijst van findByGbdatum() duidelijk uit te printen
	public static void printFindByGbdatum(String gbdatum) throws SQLException {
		for(Reiziger r : reizigerDao.findByGbdatum(gbdatum)) {
			if(r.getTussenvoegsel() == null) {
				System.out.println(String.format("%s, %s %s, %s",
						r.getReizigerID(), r.getVoorletters(), r.getAchternaam(), r.getGbdatum()));
			} else {
				System.out.println(String.format("%s, %s %s %s, %s",
						r.getReizigerID(), r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam(), r.getGbdatum()));
			}
		}
		System.out.println();
	}
}
