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
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "budget_id")
	private Budget budget;
	
	//Liste des dépenses qui concernent le participant
	@ManyToMany
	@JoinTable(name = "participant_expense", joinColumns = @JoinColumn(name = "participant_id"), inverseJoinColumns = @JoinColumn(name = "expense_id"))
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

	public Participant(String username, User user, Budget budget) {
		super();
		this.username = username;
		this.user = user;
		this.budget = budget;
		expenses = new ArrayList<Expense>();
	}
	
	public Participant(String username) {
		super();
		this.username = username;
		expenses = new ArrayList<Expense>();
	}
	
	public Participant(String username, User user) {
		super();
		this.username = username;
		this.user = user;
		expenses = new ArrayList<Expense>();
	}

	public Participant() {
		super();
		expenses = new ArrayList<Expense>();
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", username=" + username + ", budget=" + budget + "]";
	}
	
		
	
}
