package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import fr.poec.java.application_budget.Dto.ParticipantDto;
import fr.poec.java.application_budget.Entities.Participant;

public interface ParticipantService {
	
	public List<Participant> getParticipantsByIdUser(int userId);
	
    public List <Participant> getParticipantsByIdBudget (int budgetId);
    
    public ParticipantDto getParticipantByIdBudgetAndIdUser(int budgetId, int userId);

    public Participant getParticipantById(int id);
    
	public void deleteParticipantById(int id);
	
	public Participant saveParticipant(Participant participant);
	
	public Participant updateParticipant(Participant participant);
	
	 public ParticipantDto getParticipantDtoById(int id);
	 
	 public List <ParticipantDto> getParticipantsDtoByIdBudget (int budgetId);
    
}
