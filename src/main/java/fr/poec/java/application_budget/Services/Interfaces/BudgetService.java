package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Participant;

public interface BudgetService {
	
	public List<Budget> getAllBudget();
	
	public Budget getBudgetById(int id);
	
	public List<Budget> getBudgetsByIdUser(int userId);

	public List <Participant> getParticipantsByIdBudget(int budgetId);
	
	public Budget saveOrUpdateBudget(Budget budget);
	
	public void deleteBudgetById(int id);
	
	public int getBudgetByIdMax();

}
