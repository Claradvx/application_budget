package fr.poec.java.application_budget.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.poec.java.application_budget.Entities.Budget;
import fr.poec.java.application_budget.Entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{


    @Query(nativeQuery = true, value = "SELECT * FROM expense WHERE budget_id = :budget")
    List<Expense> getExpensesByIdBudget(@Param("budget") int budgetId);
   
    @Query(value = "SELECT e FROM Expense e WHERE e.payeur.id = :payeur")
    List<Expense> getExpensesByPayeur(@Param("payeur") int payeurId);
    
	public Expense getExpenseById(int id);
   
}
