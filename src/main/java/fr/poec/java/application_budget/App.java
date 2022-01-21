package fr.poec.java.application_budget;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Repositories.BudgetRepository;
import fr.poec.java.application_budget.Repositories.ExpenseRepository;
import fr.poec.java.application_budget.Repositories.ParticipantRepository;
import fr.poec.java.application_budget.Repositories.UserRepository;

@SpringBootApplication
public class App implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ParticipantRepository participantRepo;
	
	@Autowired
	BudgetRepository budgetRepo;
	
	@Autowired
	ExpenseRepository expenseRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	User u1 = new User("Nom1", "Prenom1", "mail1", "mdp1", 37);
	
	userRepo.save(u1);
	
	Participant p1 = new Participant("participant1", u1);
	
	Participant p2 = new Participant("participant2");
	

	
	Budget b1 = new Budget("Budget1", "Test Budget FBZ pause dej");
	
	budgetRepo.save(b1);
	
	p1.setBudget(b1);
	p2.setBudget(b1);
	
	participantRepo.save(p1);
	participantRepo.save(p2);
	
	Expense e1 = new Expense("Expense 1", "Test expense FBZ pause dej", b1, 100, p1);
	
	List<Participant> lste1 = e1.getBeneficiaires();
	
	lste1.add(p1);
	lste1.add(p2);
	
	expenseRepo.save(e1);
	
	System.out.println("\n");
	System.out.println(u1 + "\n");
	System.out.println(p1 + "\n");
	System.out.println(p2 + "\n");
	System.out.println(b1 + "\n");
	System.out.println(e1 + "\n");
	System.out.println(lste1 + "\n");
	System.out.println("\n");
	
	}

}
