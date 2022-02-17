package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.poec.java.application_budget.Entities.Expense;

public interface ExpenseService {
	
	//Ajout FBZ
	List<Expense> getAllExpensesByIdBudget(int budgetId);
	
	//Ajout FBZ
    List<Expense> getAllExpensesByPayeur(int payeurId);
	
	
	
}
