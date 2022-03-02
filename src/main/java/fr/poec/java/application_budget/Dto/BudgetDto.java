package fr.poec.java.application_budget.Dto;

import java.util.ArrayList;
import java.util.List;

import fr.poec.java.application_budget.Entities.Participant;

public class BudgetDto {

	private int id;
	
	private String name;
	
	private String description;

//	private List<Participant> membersBudget;

	
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

//	public List<Participant> getMembersBudget() {
//		return membersBudget;
//	}
//
//	public void setMembersBudget(List<Participant> membersBudget) {
//		this.membersBudget = membersBudget;
//	}

	public BudgetDto(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
//		this.membersBudget = membersBudget;
	}

	public BudgetDto() {
		super();
//		membersBudget = new ArrayList<Participant>();
	}

}
