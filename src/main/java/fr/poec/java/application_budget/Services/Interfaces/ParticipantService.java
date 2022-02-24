package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;

public interface ParticipantService {
	
	public List<Participant> getParticipantsByIdUser(int userId);
	
    public List <Participant> getParticipantsByIdBudget (int budgetId);

    public Participant getParticipantById(int id);
    
	public void deleteParticipantById(int id);
	
	public Participant saveOrUpdateParticipant(Participant participant);
    
}
