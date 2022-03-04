package fr.poec.java.application_budget.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.poec.java.application_budget.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findById(int id);
	
	public User getUserById(int id);
	
	public User findByUsername(String username);
	
	public User getUserByName(String name);
	
//	public User saveUser (User user);
	
//	public User updateUser (User user);

}
