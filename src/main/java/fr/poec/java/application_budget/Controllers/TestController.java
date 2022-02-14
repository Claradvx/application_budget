package fr.poec.java.application_budget.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Entities.Budget;
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
	

    @GetMapping(value="/budget", produces = "application/json")
    public Budget getById(){
        return budgetservice.getById(2);
    }
    
    @GetMapping(value="/budgets", produces = "application/json")
    public List<Budget> getAllBudget(){
        return budgetservice.getAllBudget();
    }
    
//    @GetMapping(value="/{id}", produces = "application/json")
//    public List<Participant> getAllParticipantsByIdUser(@PathVariable int id){
//    	
//        return participantservice.getAllParticipantsByIdUser(id);
//    }
    
    @GetMapping(value="/{id}", produces = "application/json")
    public List<Budget> getAllBudgetsByIdUser(@PathVariable int id){
        return budgetservice.getAllBudgetsByIdUser(id);
    }
}
