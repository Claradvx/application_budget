package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Expense;

public interface ExpenseService {
	
	public List<Expense> getExpensesByIdBudget(int budgetId);
	
	public List<Expense> getExpensesByPayeur(int payeurId);
	
	public Expense getExpenseById(int id);
	
	public void deleteExpenseById(int id);
	
	public Expense saveOrUpdateExpense(Expense expense);
	
}
