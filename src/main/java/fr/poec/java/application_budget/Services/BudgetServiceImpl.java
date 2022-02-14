package fr.poec.java.application_budget.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.Budget;
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
	public Budget getById(int id) {
		return budgetRepo.getById(id);
	}

	@Override
	public List<Budget> getAllBudgetsByIdUser(int userId) {
		return budgetRepo.getAllBudgetsByIdUser(userId);
	}
}
