package fr.poec.java.application_budget.Entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;

	//To do : ajouter Devise
	
	//Liste des participants au budget
	
	//Test relation bi directionnelle
	@OneToMany(mappedBy = "budget")
	private List<Participant> membersBudget;
	
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

	public Budget(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Budget() {
		super();
	}

	@Override
	public String toString() {
		return "Budget n°" + id + " : name=" + name + ", description=" + description;
	}
	
	
}
