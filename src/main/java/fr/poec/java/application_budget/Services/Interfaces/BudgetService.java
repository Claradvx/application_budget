package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import fr.poec.java.application_budget.Entities.Budget;

public interface BudgetService {
	
	public List<Budget> getAllBudget();
	
	public Budget getBudgetById(int id);
	
	public List<Budget> getBudgetsByIdUser(int userId);

//	public List <Participant> getParticipantsByIdBudget(int budgetId);
	
	public Budget updateBudget(Budget budget);
	
	public Budget saveBudget(Budget budget);
	
	public void deleteBudgetById(int id);
	
	public int getBudgetByIdMax();

}
