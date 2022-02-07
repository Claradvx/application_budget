package fr.poec.java.application_budget.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Repositories.Interfaces.ExpenseRepository;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	
	@Autowired
	private ExpenseRepository expenseRepo;
}
