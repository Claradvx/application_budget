package fr.poec.java.application_budget.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.Expense;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Repositories.ParticipantRepository;
import fr.poec.java.application_budget.Repositories.UserRepository;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	ParticipantRepository participantRepo;

	@Override
	public List<Participant> getParticipantsByIdUser(int userId) {
		return participantRepo.getParticipantsByIdUser(userId);
	}

	@Override
	public List<Participant> getParticipantsByIdBudget(int budgetId) {
		return participantRepo.getParticipantsByIdBudget(budgetId);
	}

	@Override
	public Participant getParticipantById(int id) {
		return participantRepo.getParticipantById(id);
	}

	@Override
	public void deleteParticipantById(int id) {
		participantRepo.deleteById(id);
	}

	@Override
	public Participant saveOrUpdateParticipant(Participant participant) {
		Participant newParticipant = participantRepo.save(participant);
		return newParticipant;
	}
	
}
