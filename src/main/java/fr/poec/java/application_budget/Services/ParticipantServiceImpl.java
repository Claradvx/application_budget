package fr.poec.java.application_budget.Services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Dto.ParticipantDto;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Repositories.ParticipantRepository;

import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	ParticipantRepository participantRepo;
	
    @Autowired
    private ModelMapper mapper;

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
	
	public Participant updateParticipant(Participant participant) {
		Participant newParticipant = getParticipantById(participant.getId());
		if (participant.getUsername() != null) {
			newParticipant.setUsername(participant.getUsername());
		}
		if (participant.getUser() != null) {
			newParticipant.setUser(participant.getUser());
		}
		if (participant.getBudget() != null) {
			newParticipant.setBudget(participant.getBudget());
		}
		return participantRepo.save(newParticipant);
	}

	//Ajout test Dto
	@Override
	public ParticipantDto getParticipantDtoById(int id) {
		ParticipantDto participantDto = mapper.map(participantRepo.getParticipantById(id), ParticipantDto.class);
		return participantDto;
	}

	@Override
	public List<ParticipantDto> getParticipantsDtoByIdBudget(int budgetId) {
		List<ParticipantDto> lstDto = new ArrayList<>();
		List<Participant> lst = participantRepo.getParticipantsByIdBudget(budgetId);
		for (Participant p : lst) {
			lstDto.add(mapper.map(p, ParticipantDto.class));
		}
		return lstDto;
	}
	
}
