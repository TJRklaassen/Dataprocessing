package dataprocessing.P2;

import java.sql.Date;
import java.sql.SQLException;

public class Main2 {
	private static OVChipkaartOracleDao kaartDao = new OVChipkaartOracleDao();
	
	public static void main(String[] arg) throws SQLException {
		//Testen of findAll() werkt
		System.out.println("findAll() test:");
		printFindAll();
		
		//Testen of findByKaartnummer() werkt
		System.out.println("findByKaartnummer() test:");
		printFindByKaartnummer(68514);
		
		//Testen of save() en findByKaarthouder() werkt
		System.out.println("save() en findByKaarthouder() test:");
		Reiziger r1 = new Reiziger(2, "B", "van", "Rijn", Date.valueOf("2002-10-22"));
		OVChipkaart ov1 = new OVChipkaart(24585, Date.valueOf("2023-05-11"), 1, 10.5, r1);
		kaartDao.save(ov1);
		printFindByKaarthouder(r1);
		
		//Testen of delete() werkt
		System.out.println("delete() test:");
		kaartDao.delete(ov1);
		printFindByKaarthouder(r1);
		
		//Testen of update() werkt
		System.out.println("update() test:");
		OVChipkaart ov2 = new OVChipkaart(68514, Date.valueOf("2019-04-16"), 2, 5.2, r1);
		kaartDao.update(ov2);
		printFindByKaartnummer(68514);
		
		//Herstelt oude waarden om later opnieuw update() te kunnen testen
		Reiziger r2 = new Reiziger(3, "H", null, "Lubben", Date.valueOf("1998-08-11"));
		ov2 = new OVChipkaart(68514, Date.valueOf("2020-03-31"), 1, 2.5, r2);
		kaartDao.update(ov2);
	}
	
	private static void printFindAll() throws SQLException {
		for(OVChipkaart ov : kaartDao.findAll()) {
			Reiziger r = ov.getKaarthouder();
			if(r.getTussenvoegsel() != null) {
				System.out.println(String.format("Kaartnummer: %s, Einddatum: %s, Klasse: %s, Saldo: %s, Naam: %s %s %s",
						ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam()));
			} else {
				System.out.println(String.format("Kaartnummer: %s, Einddatum: %s, Klasse: %s, Saldo: %s, Naam: %s %s",
						ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), r.getVoorletters(), r.getAchternaam()));
			}
		}
		System.out.println();
	}
	
	private static void printFindByKaartnummer(int nummer) throws SQLException {
		for(OVChipkaart ov : kaartDao.findByKaartnummer(nummer)) {
			Reiziger r = ov.getKaarthouder();
			if(r.getTussenvoegsel() != null) {
				System.out.println(String.format("Kaartnummer: %s, Einddatum: %s, Klasse: %s, Saldo: %s, Naam: %s %s %s",
						ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam()));
			} else {
				System.out.println(String.format("Kaartnummer: %s, Einddatum: %s, Klasse: %s, Saldo: %s, Naam: %s %s",
						ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), r.getVoorletters(), r.getAchternaam()));
			}
		}
		System.out.println();
	}
	
	private static void printFindByKaarthouder(Reiziger kaarthouder) throws SQLException {
		for(OVChipkaart ov : kaartDao.findByKaarthouder(kaarthouder)) {
			Reiziger r = ov.getKaarthouder();
			if(r.getTussenvoegsel() != null) {
				System.out.println(String.format("Kaartnummer: %s, Einddatum: %s, Klasse: %s, Saldo: %s, Naam: %s %s %s",
						ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam()));
			} else {
				System.out.println(String.format("Kaartnummer: %s, Einddatum: %s, Klasse: %s, Saldo: %s, Naam: %s %s",
						ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), r.getVoorletters(), r.getAchternaam()));
			}
		}
		System.out.println();
	}
}
