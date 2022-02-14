package fr.poec.java.application_budget.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Repositories.ParticipantRepository;
import fr.poec.java.application_budget.Repositories.UserRepository;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	ParticipantRepository participantRepo;

	@Override
	public List<Participant> getAllParticipantsByIdUser(int userId) {
		return participantRepo.getAllParticipantsByIdUser(userId);
	}
}
