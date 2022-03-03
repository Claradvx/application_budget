package fr.poec.java.application_budget.Dto;

import java.util.List;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.User;

public class ParticipantDtoAll {

	private int id;
	
	private String username;
	
	private User user;
	
	private Budget budget;
	
	private List<Expense> expenses;

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

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public ParticipantDtoAll(String username, User user, Budget budget, List<Expense> expenses) {
		super();
		this.username = username;
		this.user = user;
		this.budget = budget;
		this.expenses = expenses;
	}

	public ParticipantDtoAll() {
		super();
	}
	
}
