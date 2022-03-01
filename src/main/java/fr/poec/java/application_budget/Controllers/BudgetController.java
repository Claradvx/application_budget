package fr.poec.java.application_budget.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Services.Interfaces.BudgetService;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@RestController
@RequestMapping("/")
public class BudgetController {

	@Autowired
	BudgetService budgetService;
	
	@Autowired
	ParticipantService participantService;
	
	@Autowired
	ExpenseService expenseService;

	
	@GetMapping(value="budgets", produces = "application/json")
	public List<Budget> getAllBudget(){
		return budgetService.getAllBudget();
	}
	
	@GetMapping(value="user{id}/budgets", produces = "application/json")
	public List<Budget> getBudgetsByIdUser(@PathVariable int id){
		return budgetService.getBudgetsByIdUser(id);
	}

	@GetMapping(value="budget{id}", produces = "application/json")
	public Budget getBudgetById(@PathVariable int id) {
		return budgetService.getBudgetById(id);
	}
	
	@GetMapping(value="budgetmax", produces = "application/json")
	public Budget getBudgetByIdMax() {
		int id = budgetService.getBudgetByIdMax();
		return budgetService.getBudgetById(id);
	}
	
	
	// récupérer la liste des participants du budget
	// suppression de chaque participant
	// suppression du budget
	@DeleteMapping(value="deletebudget{id}", produces = "text/plain")
	public String deleteBudgetById(@PathVariable int id) {
		List<Participant> lstParticipants = participantService.getParticipantsByIdBudget(id);
		List<Expense> lstExpenses = expenseService.getExpensesByIdBudget(id);
		String message = "";
		
		for (Expense e : lstExpenses) {
			expenseService.deleteExpenseById(e.getId());
			message += " \n expense " + e.getId();
		}
	
		for (Participant p : lstParticipants) {
			participantService.deleteParticipantById(p.getId());
			message += " \n participant " + p.getId();
		}
		budgetService.deleteBudgetById(id);
		return "Budget supprimé "  + message;
	}
	
	@PutMapping(value="updatebudget", consumes="application/json", produces = "text/plain")
	//@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateBudget(@RequestBody Budget budget){
		budgetService.saveOrUpdateBudget(budget);
		return "Budget mis à jour avec succès";
	}

	@PostMapping(value="savebudget", consumes="application/json", produces = "application/json")
	//@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public int saveBudget(@RequestBody Budget budget){
		budgetService.saveOrUpdateBudget(budget);
		return budget.getId();
	}

}
