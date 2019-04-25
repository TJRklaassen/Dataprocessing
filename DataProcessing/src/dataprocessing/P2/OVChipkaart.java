package dataprocessing.P2;

import java.sql.Date;

public class OVChipkaart {
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private int saldo;
	private Reiziger kaarthouder;
	
	public OVChipkaart(int kaartNummer, Date geldigTot, int klasse, int saldo, Reiziger kaarthouder) {
		setKaartNummer(kaartNummer);
		setGeldigTot(geldigTot);
		setKlasse(klasse);
		setSaldo(saldo);
		setKaarthouder(kaarthouder);
	}
	
	public int getKaartNummer() {
		return kaartNummer;
	}
	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
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
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public Reiziger getKaarthouder() {
		return kaarthouder;
	}
	public void setKaarthouder(Reiziger kaarthouder) {
		this.kaarthouder = kaarthouder;
	}
	
	
}
