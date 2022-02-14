package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import fr.poec.java.application_budget.Entities.Participant;

public interface ParticipantService {
	
	public List<Participant> getAllParticipantsByIdUser(int userId);

}
