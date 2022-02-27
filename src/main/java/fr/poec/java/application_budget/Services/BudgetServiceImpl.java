package fr.poec.java.application_budget.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Repositories.BudgetRepository;
import fr.poec.java.application_budget.Services.Interfaces.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	private BudgetRepository budgetRepo;
	
	public List<Budget> getAllBudget() {
		return budgetRepo.findAll();
	}

	@Override
	public Budget getBudgetById(int id) {
		return budgetRepo.getBudgetById(id);
	}

	@Override
	public List<Budget> getBudgetsByIdUser(int userId) {
		return budgetRepo.getBudgetsByIdUser(userId);
	}

//	@Override
//	public List<Participant> getParticipantsByIdBudget(int budgetId) {
//		return budgetRepo.getParticipantsByIdBudget(budgetId);
//	}

	@Override
	public Budget saveOrUpdateBudget(Budget budget) {
		Budget newbudget = budgetRepo.save(budget);
		return newbudget;
	}

	@Override
	public void deleteBudgetById(int id) {
		budgetRepo.deleteById(id);
	}

	@Override
	public int getBudgetByIdMax() {
		return budgetRepo.getBudgetByIdMax();
	}
}
