package fr.poec.java.application_budget.Services.Interfaces;

import java.util.List;

import fr.poec.java.application_budget.Dto.ParticipantDto;
import fr.poec.java.application_budget.Entities.Participant;

public interface ParticipantService {
	
	public List<Participant> getParticipantsByIdUser(int userId);
	
    public List <Participant> getParticipantsByIdBudget (int budgetId);

    public Participant getParticipantById(int id);
    
	public void deleteParticipantById(int id);
	
	public Participant saveOrUpdateParticipant(Participant participant);
	
	public Participant updateParticipant(Participant participant);
	
	//Ajout test Dto
	 public ParticipantDto getParticipantDtoById(int id);
	 
	 public List <ParticipantDto> getParticipantsDtoByIdBudget (int budgetId);
    
}
