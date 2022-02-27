package fr.poec.java.application_budget.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Expense {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;
	
	//To do : Category
	
	@ManyToOne
	//@JsonIgnore
	private Budget budget;
	
	private double montant;
	
	//Participant ayant payé. Peux ne pas être concerné par la dépense
	@ManyToOne
	//@JsonIgnore
	private Participant payeur;
	
	//Participants concernés par la dépense
	@ManyToMany
	@JoinTable(name = "participant_expense", joinColumns = @JoinColumn(name = "expense_id"), inverseJoinColumns = @JoinColumn(name = "participant_id"))
	//@JsonIgnore
	private List<Participant> beneficiaires;

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

	public Participant getPayeur() {
		return payeur;
	}

	public void setPayeur(Participant payeur) {
		this.payeur = payeur;
	}

	public List<Participant> getBeneficiaires() {
		return beneficiaires;
	}

	public void setBeneficiaires(List<Participant> beneficiaires) {
		this.beneficiaires = beneficiaires;
	}

	public Expense(String name, String description, Budget budget, double montant, Participant payeur) {
		super();
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.montant = montant;
		this.payeur = payeur;
		beneficiaires = new ArrayList<Participant>();
	}

	public Expense() {
		super();
		beneficiaires = new ArrayList<Participant>();
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", name=" + name + ", description=" + description + ", montant=" + montant + "]";
	}
	
		
}

