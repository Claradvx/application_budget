package fr.poec.java.application_budget.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Services.Interfaces.BudgetService;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;
import fr.poec.java.application_budget.Services.Interfaces.UserService;

@RestController
@RequestMapping("/")
public class BalanceController {

	@Autowired
	ParticipantService participantService;

	@Autowired
	ExpenseService expenseService;

	
	@GetMapping(value="budget{id}/balance", produces = "application/json")
	public ArrayList<double[]> getParticipantsByBudgetId(@PathVariable int id){
		Map<Integer, Double> scaleMap = new HashMap<>();
		Map<Integer, Double> realCostMap = new HashMap<>();
		double realCost;
		Map<Integer, Double> paymentMap = new HashMap<>();
		double payment;
		List<Participant> participants = participantService.getParticipantsByIdBudget(id);
		for (Participant p : participants) {
			realCost = 0;
			List<Expense> expensesRc = p.getExpenses();
			for (Expense e : expensesRc) {
				realCost += e.getMontant() / e.getBeneficiaires().size();
			}
			realCostMap.put(p.getId(), realCost);
		}

		for (Participant p : participants) {
			payment = 0;
			List<Expense> expensesP = expenseService.getExpensesByPayeur(p.getId());
			for (Expense e : expensesP) {
				payment += e.getMontant();
			}
			paymentMap.put(p.getId(), payment);
		}

		for (Participant p : participants) {
			double scale = (paymentMap.get(p.getId()) - realCostMap.get(p.getId()));
			scaleMap.put(p.getId(), scale);
		}
		
		ArrayList<double[]> balance = new ArrayList<double[]>();
		int i = 0;
		while (scaleMap.size() > 0) {
			double maxVal = 0;
			double minVal = 0;
			int maxId = 0;
			int minId = 0;
			for (Map.Entry<Integer, Double> entry : scaleMap.entrySet()) {
				Integer key = entry.getKey();
				Double val = entry.getValue();
				if (val > maxVal) {
					maxVal = val;
					maxId = key;
				}

				if (val < minVal) {
					minVal = val;
					minId = key;
				}
			}
			double idpayeur = 0;
			double mt= 0;
			double idreceveur = 0;
			if (maxVal < Math.abs(minVal)) {
				scaleMap.remove(maxId);
				double total = 0;
				for (Map.Entry<Integer, Double> entry : scaleMap.entrySet()) {
					Integer key = entry.getKey();
					Double val = entry.getValue();
					if (key != minId) {
						total += val;
					} 
				}
				scaleMap.put(minId, total*-1);
				idpayeur = minId;
				mt = maxVal;
				idreceveur = maxId;
			}

			if (maxVal == Math.abs(minVal)){
				scaleMap.remove(maxId);
				scaleMap.remove(minId);
				idpayeur = minId;
				mt = maxVal;
				idreceveur = maxId;
			}

			if (maxVal > Math.abs(minVal)){
				scaleMap.remove(minId);
				double total = 0;
				for (Map.Entry<Integer, Double> entry : scaleMap.entrySet()) {
					Integer key = entry.getKey();
					Double val = entry.getValue();
					if (key != maxId) {
						total += val;
					} 
					scaleMap.put(maxId, total*-1);
					idpayeur = minId;
					mt = (-minVal);
					idreceveur = maxId;
				}
			}
			double[] tour = {idpayeur, mt, idreceveur};
			balance.add(i,tour);
			i++;
		}
		return balance;
	}
}
