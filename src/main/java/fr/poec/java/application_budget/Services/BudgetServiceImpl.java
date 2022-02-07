package fr.poec.java.application_budget.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Repositories.Interfaces.BudgetRepository;
import fr.poec.java.application_budget.Services.Interfaces.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	private BudgetRepository budgetRepo;
}
