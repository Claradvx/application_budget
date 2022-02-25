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

import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Services.Interfaces.BudgetService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@RestController
@RequestMapping("/")
public class ParticipantController {
	
	@Autowired
	BudgetService budgetService;

	@Autowired
	ParticipantService participantService;

	
	@GetMapping(value="budget{id}/participants", produces = "application/json")
	public List<Participant> getParticipantsByIdBudget(@PathVariable int id){
		return budgetService.getParticipantsByIdBudget(id);
	}
	
	@GetMapping(value="user{id}/participants", produces = "application/json")
	public List<Participant> getParticipantsByIdUser(@PathVariable int id){
		return participantService.getParticipantsByIdUser(id);
	}
	
	@GetMapping(value="participant{id}", produces = "application/json")
	public Participant getParticipantById(@PathVariable int id){
		return participantService.getParticipantById(id);
	}
	
	@DeleteMapping(value="deleteparticipant{id}", produces = "text/plain")
	public String deleteParticipantById(@PathVariable int id) {
		participantService.deleteParticipantById(id);
		return "Participant supprimé";
	}
	
	@PutMapping(value="updateparticipant", consumes="application/json", produces = "text/plain")
	public String updateParticipant(@RequestBody Participant participant){
		participantService.saveOrUpdateParticipant(participant);
		return "Participant mis à jour avec succès";
	}

	@PostMapping(value="saveparticipant", consumes="application/json", produces = "text/plain")
	public String saveParticipant(@RequestBody Participant participant){
		participantService.saveOrUpdateParticipant(participant);
		return "Participant sauvegardé avec succès";
	}
}
