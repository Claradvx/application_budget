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


	@Override
	public List<Expense> getExpensesByIdBudget(int budgetId) {
		return expenseRepo.getExpensesByIdBudget(budgetId);
	}
	
	@Override
	public List<Expense> getExpensesByPayeur(int payeurId) {
		return expenseRepo.getExpensesByPayeur(payeurId);
	}

	@Override
	public Expense getExpenseById(int id) {
		return expenseRepo.getExpenseById(id);
	}

	@Override
	public void deleteExpenseById(int id) {
		expenseRepo.deleteById(id);
	}
	
	@Override
	public Expense saveOrUpdateExpense(Expense expense) {
		Expense newExpense = expenseRepo.save(expense);
		return newExpense;
	}
}
