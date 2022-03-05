package fr.poec.java.application_budget.Services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import fr.poec.java.application_budget.Dto.ParticipantDto;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Repositories.ParticipantRepository;
import fr.poec.java.application_budget.Services.Interfaces.ExpenseService;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	ParticipantRepository participantRepo;
	
	@Autowired
	ExpenseService expenseService;
	
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
	public ParticipantDto getParticipantByIdBudgetAndIdUser(int budgetId, int userId) {
		ParticipantDto participantDto = mapper.map(participantRepo.getParticipantByIdBudgetAndIdUser(budgetId, userId), ParticipantDto.class);
		return participantDto;
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
	public Participant saveParticipant(Participant participantUpdated) {
		participantRepo.save(participantUpdated);
		return participantUpdated;
	}
	
	public Participant updateParticipant(Participant participantUpdated) {
		Participant existingParticipant = getParticipantById(participantUpdated.getId());
		if (participantUpdated.getUsername() != null) {
			existingParticipant.setUsername(participantUpdated.getUsername());
		}
		if (participantUpdated.getUser() != null) {
			existingParticipant.setUser(participantUpdated.getUser());
		}
		return participantRepo.save(existingParticipant);
	}

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
