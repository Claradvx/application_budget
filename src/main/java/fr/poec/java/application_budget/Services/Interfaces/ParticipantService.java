package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.poec.java.application_budget.Entities.Participant;

public interface ParticipantService {
	
	public List<Participant> getAllParticipantsByIdUser(int userId);
	
    // Ajout FBZ
    List <Participant> getAllParticipantsByIdBudget (int budgetId);

}
