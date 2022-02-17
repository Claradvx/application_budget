package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Participant;

public interface BudgetService {
	
	public List<Budget> getAllBudget();
	
	public Budget getById(int id);
	
	public List<Budget> getAllBudgetsByIdUser(int userId);
	
	//Ajout FBZ
	List <Participant> getMembersBudgetById (int budgetId);
	

}
