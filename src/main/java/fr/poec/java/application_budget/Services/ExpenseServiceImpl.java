package fr.poec.java.application_budget.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Repositories.ExpenseRepository;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	
	@Autowired
	private ExpenseRepository expenseRepo;

	//Ajout FBZ
	@Override
	public List<Expense> getAllExpensesByIdBudget(int budgetId) {
		return expenseRepo.getAllExpensesByIdBudget(budgetId);
	}

	//Ajout FBZ
	@Override
	public List<Expense> getAllExpensesByPayeur(int payeurId) {
		return expenseRepo.getAllExpensesByPayeur(payeurId);
	}
}
