package hu.nl.hibernate;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REIZIGER")
public class Reiziger {
	@Id
	@Column(name = "REIZIGERID")
	private int reizigerID;
	
	@Column(name = "VOORLETTERS")
	private String voorletters;
	
	@Column(name = "TUSSENVOEGSEL")
	private String tussenvoegsel;
	
	@Column(name = "ACHTERNAAM")
	private String achternaam;
	
	@Column(name = "GEBORTEDATUM")
	private Date gbdatum;
	
	//private ArrayList<OVChipkaart> kaarten = new ArrayList<OVChipkaart>();
	
	public Reiziger() {}
	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date gbdatum) {
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
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

//	public ArrayList<OVChipkaart> getKaarten() {
//		return kaarten;
//	}
//
//	public void setKaarten(ArrayList<OVChipkaart> kaarten) {
//		this.kaarten = kaarten;
//	}
}