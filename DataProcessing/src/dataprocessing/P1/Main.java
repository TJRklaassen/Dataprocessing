package dataprocessing.P1;

import java.sql.Date;
import java.util.List;

public class Main {
	public static void main(String[] arg) {
		ReizigerOracleDaoImpl odao = new ReizigerOracleDaoImpl();
		Reiziger r1 = new Reiziger("Tip", Date.valueOf("1997-04-16"), 1);
		Reiziger r2 = new Reiziger("Saar", Date.valueOf("1997-05-20"), 2);
		
		//Opslaan van reizigers naar ArrayList
		odao.save(r1);
		odao.save(r2);

		//Ophalen en uitprinten van alle reizigers
		List<Reiziger> lijst = odao.findAll();
		for(Reiziger r : lijst) {
			System.out.println(String.format("Naam: %s, Geboortedatum: %s, ID: %s",r.getNaam(),r.getGbdatum(),r.getID()));
		}
		System.out.println();
		
		//Ophalen en uitprinten van alle reizigers met een bepaalde geboortedatum
		List<Reiziger> lijst2 = odao.findByGbdatum("1997-04-16");
		for(Reiziger r : lijst2) {
			System.out.println(String.format("Naam: %s, Geboortedatum: %s, ID: %s",r.getNaam(),r.getGbdatum(),r.getID()));
		}
		System.out.println();
		
		//Verwijderen van reiziger uit ArrayList
		odao.delete(r1);
		
		//Opnieuw ophalen en uitprinten van alle reizigers
		List<Reiziger> lijst3 = odao.findAll();
		for(Reiziger r : lijst3) {
			System.out.println(String.format("Naam: %s, Geboortedatum: %s, ID: %s",r.getNaam(),r.getGbdatum(),r.getID()));
		}
		System.out.println();
		
		//Updaten van reiziger
		r2.setGbdatum(Date.valueOf("1998-05-20"));
		odao.update(r2);
		
		//Opnieuw ophalen en uitprinten van alle reizigers
		List<Reiziger> lijst4 = odao.findAll();
		for(Reiziger r : lijst4) {
			System.out.println(String.format("Naam: %s, Geboortedatum: %s, ID: %s",r.getNaam(),r.getGbdatum(),r.getID()));
		}
		
	}
}