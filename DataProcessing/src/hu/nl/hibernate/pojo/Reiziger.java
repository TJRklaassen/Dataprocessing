package hu.nl.hibernate.pojo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "REIZIGERID")
	private Set<OVChipkaart> kaarten;
	
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

	public Set<OVChipkaart> getKaarten() {
		return kaarten;
	}

	public void setKaarten(Set<OVChipkaart> kaarten) {
		this.kaarten = kaarten;
	}
}