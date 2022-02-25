package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import fr.poec.java.application_budget.Entities.Expense;

public interface ExpenseService {
	
	public List<Expense> getExpensesByIdBudget(int budgetId);
	
	public List<Expense> getExpensesByPayeur(int payeurId);
	
	public Expense getExpenseById(int id);
	
	public void deleteExpenseById(int id);
	
	public Expense saveOrUpdateExpense(Expense expense);
	
}
