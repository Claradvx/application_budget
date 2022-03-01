package fr.poec.java.application_budget.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "budget")
	@JsonIgnore
	private List<Participant> membersBudget;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<Participant> getMembersBudget() {
		return membersBudget;
	}

	public void setMembersBudget(List<Participant> membersBudget) {
		this.membersBudget = membersBudget;
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
		membersBudget = new ArrayList<Participant>();
	}

	public Budget() {
		super();
		membersBudget = new ArrayList<Participant>();
	}

	@Override
	public String toString() {
		return "Budget n°" + id + " : name=" + name + ", description=" + description;
	}
	
	
}
