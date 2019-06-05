package hu.nl.hibernate;

import java.util.ArrayList;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<OVChipkaart> staatOpKaarten = new ArrayList<OVChipkaart>();
	
	public Product(int productNummer, String productNaam, String beschrijving, double prijs) {
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}
	
	public int getProductNummer() {
		return productNummer;
	}
	
	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}
	
	public String getProductNaam() {
		return productNaam;
	}
	
	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}
	
	public String getBeschrijving() {
		return beschrijving;
	}
	
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	
	public double getPrijs() {
		return prijs;
	}
	
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}

	public ArrayList<OVChipkaart> getStaatOpKaarten() {
		return staatOpKaarten;
	}

	public void setStaatOpKaarten(ArrayList<OVChipkaart> staatOpKaarten) {
		this.staatOpKaarten = staatOpKaarten;
	}
}
