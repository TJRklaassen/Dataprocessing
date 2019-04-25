package dataprocessing.P2;

import java.sql.Date;
import java.util.List;

public class Main {
	public static void main(String[] arg) {
		ReizigerOracleDaoImpl reizigerDao = new ReizigerOracleDaoImpl();
		OVChipkaartOracleDaoImpl kaartDao = new OVChipkaartOracleDaoImpl();
		
		Reiziger r1 = new Reiziger(1,"TJR","","Klaassen",Date.valueOf("1997-04-16"));
		Reiziger r2 = new Reiziger(2,"SX","","Gugler",Date.valueOf("1997-05-20"));
		reizigerDao.save(r1);
		reizigerDao.save(r2);
		
		OVChipkaart ov1 = new OVChipkaart(1,Date.valueOf("2020-05-25"),2,5.5,r1);
		OVChipkaart ov2 = new OVChipkaart(2,Date.valueOf("2021-06-12"),1,24.6,r1);
		OVChipkaart ov3 = new OVChipkaart(3,Date.valueOf("2019-08-21"),2,10.4,r2);
		kaartDao.save(ov1);
		kaartDao.save(ov2);
		kaartDao.save(ov3);
		
		List<Reiziger> reizigerLijst = reizigerDao.findAll();
		for(Reiziger r : reizigerLijst) {
			System.out.println(String.format("ID: %s, naam: %s %s %s, geboortedatum: %s", 
					r.getReizigerID(), r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam(), r.getGbdatum()));
		}
		System.out.println();
		
		List<OVChipkaart> kaartLijst = kaartDao.findAll();
		for(OVChipkaart k : kaartLijst) {
			Reiziger r = k.getKaarthouder();
			System.out.println(String.format("Kaartnummer: %s, vervaldatum: %s, klasse: %s, saldo: %s, kaarthouder: %s %s %s",
					k.getKaartNummer(), k.getGeldigTot(), k.getKlasse(), k.getSaldo(),
					r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam()));
		}
		System.out.println();
		
		kaartLijst = kaartDao.findByKaarthouder(r1);
		for(OVChipkaart k : kaartLijst) {
			Reiziger r = k.getKaarthouder();
			System.out.println(String.format("Kaartnummer: %s, vervaldatum: %s, klasse: %s, saldo: %s, kaarthouder: %s %s %s",
					k.getKaartNummer(), k.getGeldigTot(), k.getKlasse(), k.getSaldo(),
					r.getVoorletters(), r.getTussenvoegsel(), r.getAchternaam()));
		}
		System.out.println();
		
	}
}
