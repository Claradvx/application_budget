package fr.poec.java.application_budget.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Services.Interfaces.BudgetService;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;
import fr.poec.java.application_budget.Services.Interfaces.UserService;

@RestController
@RequestMapping("/home")
public class TestController {

	@Autowired
	BudgetService budgetservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	ParticipantService participantservice;
	
	@Autowired
	ExpenseService expenseservice;
	   
//    @Value("${message}")
//    private String msg;
//    
//    @RequestMapping("/")
//    public String helloWorld() {
//        return msg;//"Hello World !";
//    }
	
    
    @GetMapping(value="/budgets", produces = "application/json")
    public List<Budget> getAllBudget(){
        return budgetservice.getAllBudget();
    }
    
//    @GetMapping(value="/{id}", produces = "application/json")
//    public List<Participant> getAllParticipantsByIdUser(@PathVariable int id){
//    	
//        return participantservice.getAllParticipantsByIdUser(id);
//    }
    
    @GetMapping(value="/user{id}", produces = "application/json")
    public List<Budget> getAllBudgetsByIdUser(@PathVariable int id){
        return budgetservice.getAllBudgetsByIdUser(id);
    }
    
    @GetMapping(value="/budget{id}/expenses", produces = "application/json")
    public List<Expense> getAllExpensesByIdBudget(@PathVariable int id){
        return expenseservice.getAllExpensesByIdBudget(id);
    }
    
    @GetMapping(value="/budget{id}/participants", produces = "application/json")
    public List<Participant> getMembersBudgetById(@PathVariable int id){
        return budgetservice.getMembersBudgetById(id);
    }
    
    @GetMapping(value="/budget{id}/participant", produces = "application/json")
    public Map<Integer, Double> getAllParticipantsByBudgetId(@PathVariable int id){
    	Map<Integer, Double> scaleMap = new HashMap<>();
    	Map<Integer, Double> realCostMap = new HashMap<>();
    	double realCost;
    	Map<Integer, Double> paymentMap = new HashMap<>();
    	double payment = 0;
    	List<Participant> participants = participantservice.getAllParticipantsByIdBudget(id);
    	for (Participant p : participants) {
    		realCost = 0;
			List<Expense> expensesRc = p.getExpenses();
			for (Expense e : expensesRc) {
				realCost += e.getMontant() / e.getBeneficiaires().size();
			}
			realCostMap.put(p.getId(), realCost);
		}
    	
    	
    	for (Participant p : participants) {
			List<Expense> expensesP = expenseservice.getAllExpensesByPayeur(p.getId());
			for (Expense e : expensesP) {
				payment += e.getMontant();
			}
			paymentMap.put(p.getId(), payment);
			payment = 0;
		}
    	
    	for (Participant p : participants) {
    		scaleMap.put(p.getId(), (paymentMap.get(p.getId()) - realCostMap.get(p.getId())));
    	}
    	
    
    	
        return scaleMap;
    }
}
