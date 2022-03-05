package fr.poec.java.application_budget.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.poec.java.application_budget.Entities.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer>{

	public List<Participant> findByUser (int userId);
	 
    @Query(value = "SELECT p FROM Participant p WHERE p.user.id = :user")
    public List<Participant> getParticipantsByIdUser(@Param("user") int userId);

    @Query(value = "SELECT p FROM Participant p WHERE p.budget.id = :budget")
    public List<Participant> getParticipantsByIdBudget(@Param("budget") int budgetId);

    @Query(value = "SELECT p FROM Participant p WHERE p.budget.id = :budget and p.user.id = :user")
    public Participant getParticipantByIdBudgetAndIdUser(@Param("budget") int budgetId, @Param("user") int userId);
    
    public Participant getParticipantById(int id);
}
