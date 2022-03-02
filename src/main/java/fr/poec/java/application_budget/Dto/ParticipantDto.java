package fr.poec.java.application_budget.Dto;

import fr.poec.java.application_budget.Entities.User;

public class ParticipantDto {

	private int id;
	
	private String username;
	
	private User user;
	
	private BudgetDto budget;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BudgetDto getBudget() {
		return budget;
	}

	public void setBudget(BudgetDto budget) {
		this.budget = budget;
	}

	public ParticipantDto(String username, User user, BudgetDto budget) {
		super();
		this.username = username;
		this.user = user;
		this.budget = budget;
	}

	public ParticipantDto() {
		super();
	}
	
	
	
}
