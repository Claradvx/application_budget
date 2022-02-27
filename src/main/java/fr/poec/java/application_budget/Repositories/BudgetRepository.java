package fr.poec.java.application_budget.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Participant;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer>{

    @Query(value = "SELECT b FROM Participant p JOIN p.budget b WHERE p.user.id = :user")
    public List<Budget> getBudgetsByIdUser(@Param("user") int userId);
    

//    @Query(value = "SELECT b.membersBudget FROM Budget b WHERE b.id = :budget")
//    public List<Participant> getParticipantsByIdBudget(@Param("budget")int budgetId);
    
 
    @Query(value = "SELECT b FROM Budget b WHERE b.id = :budget")
    public Budget getBudgetById(@Param("budget")int budgetId);
    
    @Query(value = "SELECT max(b.id) FROM Budget b")
    public int getBudgetByIdMax();
   
}