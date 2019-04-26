package dataprocessing.P2;

import java.sql.Date;

public class OVChipkaart {
	private int kaartnummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private Reiziger kaarthouder;
	
	public OVChipkaart(int kaartnummer, Date geldigTot, int klasse, double saldo, Reiziger kaarthouder) {
		setKaartnummer(kaartnummer);
		setGeldigTot(geldigTot);
		setKlasse(klasse);
		setSaldo(saldo);
		setKaarthouder(kaarthouder);
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
	
	
}
