package fr.poec.java.application_budget.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.poec.java.application_budget.Entities.Participant;
import fr.poec.java.application_budget.Entities.User;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

	public List<Participant> findByUser (int userId);
	 
    @Query(value = "SELECT p FROM Participant p WHERE p.user.id = :user")
    List<Participant> getAllParticipantsByIdUser(@Param("user") int userId);

}
