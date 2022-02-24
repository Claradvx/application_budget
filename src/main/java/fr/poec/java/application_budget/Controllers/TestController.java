package fr.poec.java.application_budget.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	//    @GetMapping(value="/{id}", produces = "application/json")
	//    public List<Participant> getAllParticipantsByIdUser(@PathVariable int id){
	//    	
	//        return participantservice.getAllParticipantsByIdUser(id);
	//    }

}

