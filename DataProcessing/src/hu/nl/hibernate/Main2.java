package hu.nl.hibernate;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hu.nl.hibernate.dao.HibernateBaseDao;
import hu.nl.hibernate.dao.OVChipkaartHibernateDao;
import hu.nl.hibernate.dao.ReizigerHibernateDao;
import hu.nl.hibernate.pojo.OVChipkaart;
import hu.nl.hibernate.pojo.Reiziger;

//Ik gebruik de annotations manier voor P5. Deze main wordt voor P5 gebruikt.
public class Main2 {
	private static HibernateBaseDao dao = new HibernateBaseDao();
	private static ReizigerHibernateDao reizigerDao = new ReizigerHibernateDao();
	private static OVChipkaartHibernateDao kaartDao = new OVChipkaartHibernateDao();
	
	public static void main(String[] args) throws SQLException {
		dao.getFactory();
		
		Reiziger r1 = new Reiziger(6, "TJG", null, "Klaasen", Date.valueOf("2003-11-22"));
		OVChipkaart ov1 = new OVChipkaart(68723, Date.valueOf("2020-06-12"), 2, 5, r1);
		OVChipkaart ov2 = new OVChipkaart(68724, Date.valueOf("2020-06-12"), 1, 10, r1);
		Set<OVChipkaart> kaarten = new HashSet<OVChipkaart>();
		kaarten.add(ov1);
		kaarten.add(ov2);
		r1.setKaarten(kaarten);
		
		// create reiziger en kaarten die reiziger bezit
		reizigerDao.save(r1);
		
		// read alle reizigers met bijbehorende kaarten
		System.out.println("ALLE REIZIGERS NA SAVE:");
		printReizigers(reizigerDao.findAll());
		
		// read alle kaarten met bijbehorende kaarthouder
		System.out.println("ALLE KAARTEN NA SAVE:");
		printKaarten(kaartDao.findAll());
		
		// update reiziger
		r1.setVoorletters("TJR");
		r1.setAchternaam("Klaassen");
		reizigerDao.update(r1);
		
		System.out.println("REIZIGER TJR KLAASSEN NA UPDATE:");
		printReiziger(reizigerDao.findByReizigerid(6));
		System.out.println();
		
		
		// delete bepaalde kaarten en reizigers
		kaartDao.delete(ov1);
		kaartDao.delete(ov2);
		reizigerDao.delete(r1);
		
		System.out.println("ALLE REIZIGERS NA DELETE:");
		printReizigers(reizigerDao.findAll());
		System.out.println("ALLE KAARTEN NA DELETE:");
		printKaarten(kaartDao.findAll());
		
		dao.closeFactory();
	}

	public static void printReiziger(Reiziger r) {
		try {
			if (r.getTussenvoegsel() == null) {
				System.out.println(String.format("Reiziger: %s, %s %s, %s, bezit de volgende OV-Chipkaarten:", r.getReizigerID(), r.getVoorletters(),
						r.getAchternaam(), r.getGbdatum()));
			} else {
				System.out.println(String.format("Reiziger: %s, %s %s %s, %s, bezit de volgende OV-Chipkaarten:", r.getReizigerID(), r.getVoorletters(),
						r.getTussenvoegsel(), r.getAchternaam(), r.getGbdatum()));
			}
			
			if(r.getKaarten().isEmpty()) {
				System.out.println("Geen.");
			} else {
				for (OVChipkaart ov : r.getKaarten()) {
					System.out.println(String.format("Kaart: %s, Einddatum: %s, Klasse: %s, Saldo: %s",
							ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo()));
				}
			}
			
			System.out.println();
		} catch (Exception e) {
			System.out.println("ERROR: Reiziger niet gevonden.");
		}
	}
	
	public static void printReizigers(List<Reiziger> reizigers) {
		for(Reiziger r : reizigers) {
			printReiziger(r);
		}
		System.out.println();
	}
	
	public static void printKaart(OVChipkaart ov) {
		try {
			System.out.println(String.format("Kaart: %s, Einddatum: %s, Klasse: %s, Saldo: %s, Kaarthouder: %s",
					ov.getKaartnummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), ov.getKaarthouder().getAchternaam()));
		} catch (Exception e) {
			System.out.println("ERROR: OV-Chipkaart niet gevonden.");
		}
	}
	
	public static void printKaarten(List<OVChipkaart> kaarten) {
		for(OVChipkaart ov : kaarten) {
			printKaart(ov);
		}
		System.out.println();
		System.out.println();
	}
}













