package dataprocessing.P2;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;
	private ArrayList<OVChipkaart> kaarten = new ArrayList<OVChipkaart>();
	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum) {
		setReizigerID(reizigerID);
		setVoorletters(voorletters);
		setTussenvoegsel(tussenvoegsel);
		setAchternaam(achternaam);
		setGbdatum(gbdatum);
	}
	
	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	public ArrayList<OVChipkaart> getKaarten() {
		return kaarten;
	}

	public void setKaarten(ArrayList<OVChipkaart> kaarten) {
		this.kaarten = kaarten;
	}
}