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

import fr.poec.java.application_budget.Dto.ExpenseDto;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;

@RestController
@RequestMapping("/")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	
//	@GetMapping(value="budget{id}/expenses", produces = "application/json")
//	public List<Expense> getExpensesByIdBudget(@PathVariable int id){
//		return expenseService.getExpensesByIdBudget(id);
//	}

	//On ne récupère pas les bénéficiaires des dépenses a cause des json ignore
//	@GetMapping(value="expense{id}", produces = "application/json")
//	public Expense getExpenseById(@PathVariable int id) {
//		return expenseService.getExpenseById(id);
//	}
	

	@GetMapping(value="budget{id}/expenses", produces = "application/json")
	public List<ExpenseDto> getExpensesDtoByIdBudget(@PathVariable int id){
		return expenseService.getExpensesDtoByIdBudget(id);
	}
	
	@GetMapping(value="expense{id}", produces = "application/json")
	public ExpenseDto getExpenseDtoById(@PathVariable int id) {
		return expenseService.getExpenseDtoById(id);
	}
	
	@DeleteMapping(value="deleteexpense{id}", produces = "text/plain")
	public String deleteExpenseById(@PathVariable int id) {
		expenseService.deleteExpenseById(id);
		return "Dépense supprimée";
	}
	
	@PutMapping(value="updateexpense", consumes="application/json", produces = "text/plain")
	public String updateExpense(@RequestBody Expense expense){
		expenseService.saveOrUpdateExpense(expense);
		return "Dépense mise à jour avec succès";
	}

	@PostMapping(value="saveexpense", consumes="application/json", produces = "text/plain")
	public String saveExpense(@RequestBody Expense expense){
		expenseService.saveOrUpdateExpense(expense);
		return "Dépense sauvegardée avec succès";
	}

	
}
