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

import fr.poec.java.application_budget.Entities.Balance;
import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@RestController
@RequestMapping("/")
public class BalanceController {

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
			scaleMap.put(p.getId(), scale);
		}

		return scaleMap;
	}

//	//valeur mini
//	public double getMinValue(double minVal, double val) {
//		if (val < minVal) {
//			minVal = val;
//			return minVal;
//		}else {
//			return minVal;
//		}
//	}
//
//	//Id mini
//	public int getMinId(double minVal, int minId, double val, int key) {
//		if (val < minVal) {
//			minId = key;
//			return minId;
//		}else {
//			return minId;
//		}
//	}
//
//	//valeur maxi
//	public double getMaxValue(double maxVal, double val) {
//		if (val > maxVal) {
//			maxVal = val;
//			return maxVal;
//		}else {
//			return maxVal;
//		}
//	}
//
//	//Id maxi
//	public int getMaxId(double maxVal, int maxId, double val, int key) {
//		if (val < maxVal) {
//			maxId = key;
//			return maxId;
//		}else {
//			return maxId;
//		}
//	}

	//Resultat
	@GetMapping(value="budget{id}/scale", produces = "application/json")
	public List<Balance> getBalanceByBudgetId(@PathVariable int id){
		Map<Integer, Double> scaleMap = getScaleByParticipant(id);

		List<Balance> balance1 = new ArrayList<Balance>();
	//	ArrayList<double[]> balance = new ArrayList<double[]>();
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
//				minVal = getMinValue(minVal, entry.getValue());
//				minId = getMinId(minVal, minId, entry.getValue(), entry.getKey());
//				maxVal = getMaxValue(maxVal, entry.getValue());
//				maxId = getMaxId(maxVal, maxId, entry.getValue(), entry.getKey());
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
			//double[] tour = {idpayeur, mt, idreceveur};
			Balance tour = new Balance(i, participantService.getParticipantById(idpayeur).getUsername(), mt, participantService.getParticipantById(idreceveur).getUsername());
		//	balance.add(i,tour);
			balance1.add(tour);
			i++;
		}
		return balance1;
	}
}
