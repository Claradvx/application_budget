package fr.poec.java.application_budget.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;

	//To do : ajouter Devise
	
	//Liste des participants au budget
	
	//A priori pas besoin, à voir ^^
//	private List<Participant> membersBudget;
	//coucou
	
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
