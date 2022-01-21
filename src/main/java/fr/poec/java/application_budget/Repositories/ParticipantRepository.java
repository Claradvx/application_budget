package fr.poec.java.application_budget.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.poec.java.application_budget.Entities.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

}
