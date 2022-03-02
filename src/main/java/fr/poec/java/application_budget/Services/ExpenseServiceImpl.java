package fr.poec.java.application_budget.Services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Dto.ExpenseDto;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Repositories.ExpenseRepository;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	
	@Autowired
	private ExpenseRepository expenseRepo;
	
    @Autowired
    private ModelMapper mapper;

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
	
	@Override
	public Expense updateExpense(Expense expenseUpdated) {
		Expense existingExpense = expenseRepo.getExpenseById(expenseUpdated.getId());
		
		if (expenseUpdated.getName() != null) {
			existingExpense.setName(expenseUpdated.getName());
		}
		if (expenseUpdated.getDescription() != null) {
			existingExpense.setDescription(expenseUpdated.getDescription());
		}
		if (expenseUpdated.getMontant() != 0) {
			existingExpense.setMontant(expenseUpdated.getMontant());
		}
		if (expenseUpdated.getPayeur() != null) {
			existingExpense.setPayeur(expenseUpdated.getPayeur());
		}
		if (expenseUpdated.getBeneficiaires() != null) {
			existingExpense.setBeneficiaires(expenseUpdated.getBeneficiaires());
		}
		return expenseRepo.save(existingExpense);
	}
	
	@Override
	public List<ExpenseDto> getExpensesDtoByIdBudget(int budgetId) {
		List<ExpenseDto> lstDto = new ArrayList<ExpenseDto>();
		List<Expense> lst = expenseRepo.getExpensesByIdBudget(budgetId);
		for (Expense e : lst) {
			lstDto.add(mapper.map(e, ExpenseDto.class));
		}
		return lstDto;
	}

	@Override
	public ExpenseDto getExpenseDtoById(int id) {
		ExpenseDto expenseDto = mapper.map(expenseRepo.getExpenseById(id), ExpenseDto.class);
		return expenseDto;
	}
}
