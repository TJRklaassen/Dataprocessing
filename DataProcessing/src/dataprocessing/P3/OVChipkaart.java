package dataprocessing.P3;

import java.sql.Date;
import java.util.ArrayList;

public class OVChipkaart {
	private int kaartnummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private Reiziger kaarthouder;
	private ArrayList<Product> productenOpKaart = new ArrayList<Product>();
	
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

	public ArrayList<Product> getProductenOpKaart() {
		return productenOpKaart;
	}

	public void setProductenOpKaart(ArrayList<Product> productenOpKaart) {
		this.productenOpKaart = productenOpKaart;
	}
	
	public void addProductToKaart(Product product) {
		this.productenOpKaart.add(product);
	}
	
	public void deleteProductFromKaart(Product product) {
		this.productenOpKaart.remove(product);
	}
}
