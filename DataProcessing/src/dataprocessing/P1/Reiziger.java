package dataprocessing.P1;

import java.sql.Date;

public class Reiziger {
	private String naam;
	private Date gbdatum;
	private int ID;
	
	public Reiziger(String naam, Date gbdatum, int ID) {
		setNaam(naam);
		setGbdatum(gbdatum);
		setID(ID);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Date getGbdatum() {
		return gbdatum;
	}

	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	
}
