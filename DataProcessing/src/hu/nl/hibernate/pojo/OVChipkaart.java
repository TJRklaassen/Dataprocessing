package hu.nl.hibernate.pojo;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OV_CHIPKAART")
public class OVChipkaart {
	@Id
	@Column(name = "KAARTNUMMER")
	private int kaartnummer;
	
	@Column(name = "GELDIGTOT")
	private Date geldigTot;

	@Column(name = "KLASSE")
	private int klasse;
	
	@Column(name = "SALDO")
	private double saldo;
	
	@ManyToOne
	@JoinColumn(name = "REIZIGERID")
	private Reiziger kaarthouder;
//	private ArrayList<Product> productenOpKaart = new ArrayList<Product>();
	
	public OVChipkaart() {}
	
	public OVChipkaart(int kaartnummer, Date geldigTot, int klasse, double saldo) {
		this.kaartnummer = kaartnummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
	}
	
	public OVChipkaart(int kaartnummer, Date geldigTot, int klasse, double saldo, Reiziger kaarthouder) {
		this.kaartnummer = kaartnummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.kaarthouder = kaarthouder;
	}
	
	public int getKaartnummer() {
		return kaartnummer;
	}
	public void setKaartnummer(int kaartnummer) {
		this.kaartnummer = kaartnummer;
	}
	public Date getGeldigTot() {
		return geldigTot;
	}
	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}
	public int getKlasse() {
		return klasse;
	}
	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Reiziger getKaarthouder() {
		return kaarthouder;
	}
	public void setKaarthouder(Reiziger kaarthouder) {
		this.kaarthouder = kaarthouder;
	}

//	public ArrayList<Product> getProductenOpKaart() {
//		return productenOpKaart;
//	}
//
//	public void setProductenOpKaart(ArrayList<Product> productenOpKaart) {
//		this.productenOpKaart = productenOpKaart;
//	}
	
	
}
