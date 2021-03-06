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

import fr.poec.java.application_budget.Entities.Scale;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@RestController
@RequestMapping("/")
public class ScaleController {

	@Autowired
	ParticipantService participantService;

	@Autowired
	ExpenseService expenseService;

	//RealCost
	public Map<Integer, Double> getRealCostByParticipant(@PathVariable int id) {
		Map<Integer, Double> realCostMap = new HashMap<>();
		double realCost;

		List<Participant> participants = participantService.getParticipantsByIdBudget(id);
		for (Participant p : participants) {
			realCost = 0;
			List<Expense> expensesRc = p.getExpenses();
			for (Expense e : expensesRc) {
				realCost += e.getMontant() / e.getBeneficiaires().size();
			}
			realCostMap.put(p.getId(), realCost);
		}

		return realCostMap;
	}

	//Payment
	public Map<Integer, Double> getPaymentByParticipant(@PathVariable int id) {
		Map<Integer, Double> paymentMap = new HashMap<>();
		double payment;

		List<Participant> participants = participantService.getParticipantsByIdBudget(id);

		for (Participant p : participants) {
			payment = 0;
			List<Expense> expensesP = expenseService.getExpensesByPayeur(p.getId());
			for (Expense e : expensesP) {
				payment += e.getMontant();
			}
			paymentMap.put(p.getId(), payment);
		}
		return paymentMap;
	}


	//scale
	public Map<Integer, Double> getScaleByParticipant(@PathVariable int id) {
		Map<Integer, Double> scaleMap = new HashMap<>();

		List<Participant> participants = participantService.getParticipantsByIdBudget(id);
		Map<Integer, Double> paymentMap = getPaymentByParticipant(id);
		Map<Integer, Double> realCostMap = getRealCostByParticipant(id);

		for (Participant p : participants) {
			double scale = (paymentMap.get(p.getId()) - realCostMap.get(p.getId()));
			if (scale != 0) {
			scaleMap.put(p.getId(), scale);
			}
		}

		return scaleMap;
	}

	//Resultat
	@GetMapping(value="budget/{id}/scale", produces = "application/json")
	public List<Scale> getBalanceByBudgetId(@PathVariable int id){
		Map<Integer, Double> scaleMap = getScaleByParticipant(id);
		List<Scale> balance = new ArrayList<Scale>();
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
			int idpayeur = 0;
			double mt= 0;
			int idreceveur = 0;
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
			Scale tour = new Scale(i, participantService.getParticipantById(idpayeur).getUsername(), mt, participantService.getParticipantById(idreceveur).getUsername());
			balance.add(tour);
			i++;
		}
		return balance;
	}
}
