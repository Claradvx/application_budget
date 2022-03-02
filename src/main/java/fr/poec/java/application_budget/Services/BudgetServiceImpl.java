package fr.poec.java.application_budget.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Repositories.BudgetRepository;
import fr.poec.java.application_budget.Services.Interfaces.BudgetService;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	private BudgetRepository budgetRepo;
	
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	ParticipantService participantService;
	
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

	@Override
	public Budget updateBudget(Budget budgetUpdated) {
		Budget existingBudget = budgetRepo.getBudgetById(budgetUpdated.getId());
		List<Participant> lst = existingBudget.getMembersBudget();
		
		if (budgetUpdated.getName() != null) {
			existingBudget.setName(budgetUpdated.getName());
		}
		if (budgetUpdated.getDescription() != null) {
			existingBudget.setDescription(budgetUpdated.getDescription());
		}
		
		budgetRepo.save(existingBudget);
		
//		for (Participant p : existingBudget.getMembersBudget()) {
//			p.setExpenses(null);
//			participantService.deleteParticipantById(p.getId());
//		}
//		for (Participant p : budgetUpdated.getMembersBudget()) {
//			participantService.saveParticipant(p);
//		}
			for (Participant p : participantService.getParticipantsByIdBudget(existingBudget.getId())) {
				p.setBudget(null);	
				participantService.saveParticipant(p);
			}
			
			for (Participant p : budgetUpdated.getMembersBudget()) {
				p.setBudget(existingBudget);	
				participantService.saveParticipant(p);
			}
			
			for (Participant p : existingBudget.getMembersBudget()) {
				if (p.getBudget() == null && expenseService.getExpensesByPayeur(p.getId()) == null && p.getExpenses() == null) {
					participantService.deleteParticipantById(p.getId());
				}
			}
			
		return budgetRepo.save(existingBudget);
	}	
	
	@Override
	public Budget saveBudget(Budget budget) {
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
