package fr.poec.java.application_budget.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.poec.java.application_budget.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);
	
	public User findById(int id);

}
