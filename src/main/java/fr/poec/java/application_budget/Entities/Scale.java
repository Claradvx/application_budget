package fr.poec.java.application_budget.Entities;

public class Scale {
	
	private int id;
	
	private String payeur;
	
	private double montant;
	
	private String beneficiaire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayeur() {
		return payeur;
	}

	public void setPayeur(String payeur) {
		this.payeur = payeur;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public Scale(int id, String payeur, double montant, String beneficiaire) {
		super();
		this.id = id;
		this.payeur = payeur;
		this.montant = montant;
		this.beneficiaire = beneficiaire;
	}

}
