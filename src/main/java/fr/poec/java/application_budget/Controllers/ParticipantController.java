package fr.poec.java.application_budget.Controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.poec.java.application_budget.Dto.ParticipantDto;
import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Services.Interfaces.ParticipantService;

@RestController
@RequestMapping("/")
public class ParticipantController {
	
	@Autowired
	ParticipantService participantService;
	
    @Autowired
    private ModelMapper mapper;
	
	@GetMapping(value="budget{id}/participants", produces = "application/json")
	public List<ParticipantDto> getParticipantsDtoByIdBudget(@PathVariable int id){
		return participantService.getParticipantsDtoByIdBudget(id);
	}
	
	@GetMapping(value="participant{id}", produces = "application/json")
	public ParticipantDto getParticipantDtoById(@PathVariable int id){
		return participantService.getParticipantDtoById(id);
	}
	
	
	@GetMapping(value="user{id}/participants", produces = "application/json")
	public List<Participant> getParticipantsByIdUser(@PathVariable int id){
		return participantService.getParticipantsByIdUser(id);
	}
	
	
	@DeleteMapping(value="deleteparticipant{id}", produces = "text/plain")
	public String deleteParticipantById(@PathVariable int id) {
		participantService.deleteParticipantById(id);
		return "Participant supprimé";
	}
	
	@PutMapping(value="updateparticipant", consumes="application/json", produces = "application/json")
	public Participant updateParticipant(@RequestBody ParticipantDto participantDto){
		Participant participant = mapper.map(participantDto, Participant.class);
		participantService.updateParticipant(participant);
		return participant;
	}

	@PostMapping(value="saveparticipant", consumes="application/json", produces = "application/json")
	public Participant saveParticipant(@RequestBody ParticipantDto participantDto){
		Participant participant = mapper.map(participantDto, Participant.class);
		Participant newParticipant = participantService.saveParticipant(participant);
		return newParticipant;
	}
}
