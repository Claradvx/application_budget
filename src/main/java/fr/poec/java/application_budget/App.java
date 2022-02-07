package fr.poec.java.application_budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Entities.User;
import fr.poec.java.application_budget.Repositories.Interfaces.BudgetRepository;
import fr.poec.java.application_budget.Repositories.Interfaces.ExpenseRepository;
import fr.poec.java.application_budget.Repositories.Interfaces.ParticipantRepository;
import fr.poec.java.application_budget.Repositories.Interfaces.UserRepository;

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
	
	Participant p1 = new Participant("Fanny", u1);
	
	Participant p2 = new Participant("Clara");
	
	Participant p3 = new Participant("Thomas");
	
	Participant p4 = new Participant("Marie");
	

	
	Budget b1 = new Budget("Budget1", "Test Calcul");
	
	budgetRepo.save(b1);
	
	p1.setBudget(b1);
	p2.setBudget(b1);
	p3.setBudget(b1);
	p4.setBudget(b1);
	
	
	participantRepo.save(p1);
	participantRepo.save(p2);
	participantRepo.save(p3);
	participantRepo.save(p4);
	
	Expense e1 = new Expense("Expense 1", "Test calcul", b1, 150, p1);
	Expense e2 = new Expense("Expense 1", "Test calcul", b1, 50, p2);
	Expense e3 = new Expense("Expense 1", "Test calcul", b1, 120, p4);
	
	List<Participant> lste1 = e1.getBeneficiaires();
	
	lste1.add(p1);
	lste1.add(p2);
	lste1.add(p3);
	lste1.add(p4);
	
	List<Participant> lste2 = e2.getBeneficiaires();
	
	lste2.add(p1);
	lste2.add(p2);
	lste2.add(p3);
	lste2.add(p4);
	
	List<Participant> lste3 = e3.getBeneficiaires();
	
	lste3.add(p1);
	lste3.add(p2);
	lste3.add(p3);
	lste3.add(p4);
	
	expenseRepo.save(e1);
	expenseRepo.save(e2);
	expenseRepo.save(e3);

	List<Expense> lstexp1 = new ArrayList<Expense>();
	
	lstexp1.add(e1);
	lstexp1.add(e2);
	lstexp1.add(e3);
	
	List<Expense> lstexp2 = new ArrayList<Expense>();
	
	lstexp2.add(e1);
	lstexp2.add(e2);
	lstexp2.add(e3);
	
	List<Expense> lstexp3 = new ArrayList<Expense>();
	
	lstexp3.add(e1);
	lstexp3.add(e2);
	lstexp3.add(e3);
	
	List<Expense> lstexp4 = new ArrayList<Expense>();
	
	lstexp4.add(e1);
	lstexp4.add(e2);
	lstexp4.add(e3);
	
	p1.setExpenses(lstexp1);
	p2.setExpenses(lstexp2);
	p3.setExpenses(lstexp3);
	p4.setExpenses(lstexp4);
	
	participantRepo.save(p1);
	participantRepo.save(p2);
	participantRepo.save(p3);
	participantRepo.save(p4);
	

	
//	System.out.println("\n");
//	System.out.println(u1 + "\n");
	System.out.println(p1 + "\n");
//	System.out.println(p2 + "\n");
//	System.out.println(b1 + "\n");
	System.out.println(e1 + "\n");
//	System.out.println(lste1 + "\n");
//	System.out.println("\n");
	
	System.out.println("-----------------------Test Calcul--------------------------- ");
	
	System.out.println("-----------------------Montants des paiements effectués par chaque particpant--------------------------- ");
	//Dans repo expense => get all expenses par Payeur ou Ajouter "List<Expense> payment" dans participant pour faire un foreach (Expense e : lstExpPart)
	//Ajouter List<Participant> dans budget pour faire un foreach (Participant p : lstpartBudget) => obligation de MAJ un attribut payment?
	double paymentF = e1.getMontant();
	System.out.println("Montant Payment Fanny : " + paymentF);
	double paymentC = e2.getMontant();
	System.out.println("Montant Payment Clara : " + paymentC);
	double paymentT = 0;
	System.out.println("Montant Payment Thomas : " + paymentT);
	double paymentM = e3.getMontant();
	System.out.println("Montant Payment Marie : " + paymentM);

	
	System.out.println("-----------------------Montants des parts (real costs) de chaque particpant--------------------------- ");
	
	
	//Ajouter List<Participant> dans budget pour faire un foreach (Participant p : lstpartBudget) => obligation de MAJ un attribut Part?
	double partF = 0;
	List<Expense> lstPartF = p1.getExpenses();
	
	for (Expense e : lstPartF) {
		double total = e.getMontant();
		int nb = e.getBeneficiaires().size();
		partF += total / nb;
	}
	System.out.println("Montant Part Fanny : " + partF);
	
	double partC = 0;
	List<Expense> lstPartC = p1.getExpenses();
	
	for (Expense e : lstPartC) {
		double total = e.getMontant();
		int nb = e.getBeneficiaires().size();
		partC += total / nb;
	}
	System.out.println("Montant Part Clara : " + partC);
	
	double partT = 0;
	List<Expense> lstPartT = p1.getExpenses();
	
	for (Expense e : lstPartT) {
		double total = e.getMontant();
		int nb = e.getBeneficiaires().size();
		partT += total / nb;
	}
	System.out.println("Montant Part Thomas : " + partT);
	
	double partM = 0;
	List<Expense> lstPartM = p1.getExpenses();
	
	for (Expense e : lstPartM) {
		double total = e.getMontant();
		int nb = e.getBeneficiaires().size();
		partM += total / nb;
	}
	System.out.println("Montant Part Marie : " + partM);
	
	System.out.println("-----------------------Montant des scales par participant--------------------------- ");
	
	//Ajouter List<Participant> dans budget pour faire un foreach (Participant p : lstpartBudget) => obligation de MAJ un attribut Scale?
	double scaleF = paymentF - partF;
	System.out.println("Montant Scale Fanny : " + scaleF);
	
	double scaleC = paymentC - partC;
	System.out.println("Montant Scale Clara : " + scaleC);
	
	double scaleT = paymentT - partT;
	System.out.println("Montant Scale Thomas : " + scaleT);
	
	double scaleM = paymentM - partM;
	System.out.println("Montant Scale Marie : " + scaleM);
	
	System.out.println("-----------------------Boucle balance--------------------------- ");
	
	//Ajouter List<Participant> dans budget pour faire une déclaration en fonction du nombre de participant : String[budget.getParticipant().size()][budget.getParticipant().size()]
	// puis initialiser avec chaque participant
	
	Map<Integer, Double> nom = new HashMap<>();
	
	nom.put(p1.getId(), scaleF);
	nom.put(p2.getId(), scaleC);
	nom.put(p3.getId(), scaleT);
	nom.put(p4.getId(), scaleM);

	System.out.println(nom);
	System.out.println(nom.get(p1.getId()));
	
	System.out.println("-----------------------Fin Test Calcul--------------------------- ");
	}

}
