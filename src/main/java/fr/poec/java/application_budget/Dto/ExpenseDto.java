package fr.poec.java.application_budget.Dto;

import java.util.ArrayList;
import java.util.List;

import fr.poec.java.application_budget.Entities.Budget;

public class ExpenseDto {
	
	private int id;

	private String name;

	private String description;

	private Budget budget;
	
	private double montant;
	
	private ParticipantDto payeur;
	
	private List<ParticipantDto> beneficiaires;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public ParticipantDto getPayeur() {
		return payeur;
	}

	public void setPayeur(ParticipantDto payeur) {
		this.payeur = payeur;
	}

	public List<ParticipantDto> getBeneficiaires() {
		return beneficiaires;
	}

	public void setBeneficiaires(List<ParticipantDto> beneficiaires) {
		this.beneficiaires = beneficiaires;
	}

	public ExpenseDto(String name, String description, Budget budget, double montant, ParticipantDto payeur,
			List<ParticipantDto> beneficiaires) {
		super();
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.montant = montant;
		this.payeur = payeur;
		beneficiaires = new ArrayList<ParticipantDto>();
	}

	public ExpenseDto() {
		super();
		beneficiaires = new ArrayList<ParticipantDto>();
	}

}
